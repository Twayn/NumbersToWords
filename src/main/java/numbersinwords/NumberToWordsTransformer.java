package numbersinwords;

import static numbersinwords.Constants.*;
import static numbersinwords.INumberInWords.*;

class NumberToWordsTransformer {
	private final long nSum;
	private final String sCase;
	private final String[][] DIGIT;
	private final String[][] POWER;

	private final static long oneThousand = 1000L;

	NumberToWordsTransformer(long nSum, String sGender, String sCase) {
		this.nSum = nSum;
		this.sCase = sCase;
		switch (sCase){
			case NOMINATIVE:
				this.DIGIT = Constants.DIGIT_NOMINATIVE;
				this.POWER = Constants.POWER_NOMINATIVE;
				break;
			case GENITIVE:
				this.DIGIT = Constants.DIGIT_GENITIVE;
				this.POWER = Constants.POWER_GENITIVE;
				break;
			case DATIVE:
				this.DIGIT = Constants.DIGIT_DATIVE;
				this.POWER = Constants.POWER_DATIVE;
				break;
			case ACCUSATIVE:
				this.DIGIT = Constants.DIGIT_ACCUSATIVE;
				this.POWER = Constants.POWER_ACCUSATIVE;
				break;
			case INSTRUMENTAL:
				this.DIGIT = Constants.DIGIT_INSTRUMENTAL;
				this.POWER = Constants.POWER_INSTRUMENTAL;
				break;
			case PREPOSITIONAL:
				this.DIGIT = Constants.DIGIT_PREPOSITIONAL;
				this.POWER = Constants.POWER_PREPOSITIONAL;
				break;
			default: throw new RuntimeException("Неподдерживаемый падеж: " + sCase);
		}
	}

	String transform() {
		if (nSum == 0L) return FOR_ZERO.get(sCase);
		var sum = nSum;

		/*Найти количество групп по три разряда*/
		var length = String.format("%,d", sum).replaceAll("[^,]", "").length();
		var divisor = (long)Math.pow(oneThousand, length);

		var result = new StringBuilder();
		for (; length >= 0; length--) {
			var mny = (int) (sum / divisor);
			sum = sum % divisor;

			result.append(calcDigit(mny, length));

			divisor = divisor / oneThousand;
		}

		result.deleteCharAt(result.length() - 1);//Удаляется последний пробел

		return addPrefixForInstrumental(result.toString());
	}

	private String addPrefixForInstrumental(String result){
		if (sCase.equals(PREPOSITIONAL)){
			if (result.startsWith("о")){
				return "об " + result;
			} else return "о " + result;
		}
		return result;
	}

	private String calcDigit(int res, int length){
		final var thousandsMark = 1;
		var result = new StringBuilder();

		if (res == 0) {
			if (length == 0) {
				result.append(POWER[length][singularIndex]);
			}
		} else {
			if (res >= 100) {
				result.append(DIGIT[res / 100][hundredsIndex]);
				res %= 100;
			}
			if (res >= 20) {
				result.append(DIGIT[res / 10][decadesIndex]);
				res %= 10;
			}
			if (res >= 10) {
				result.append(DIGIT[res - 10][from11to20Index]);
			} else if (res >= 1){
				result.append(DIGIT[res][length == thousandsMark ? forThousandsIndex : forOthersIndex]);
			}

			result.append(calcPower(res, length));
		}
		return result.toString();
	}

	private String calcPower(final int res, final int length){
		switch (res) {
			case 1:
				return POWER[length][singularIndex];
			case 2:
			case 3:
			case 4:
				return POWER[length][from2to4Index];
			default:
				return POWER[length][from5to9Index];
		}
	}
}
