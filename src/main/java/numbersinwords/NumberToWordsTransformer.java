package numbersinwords;

import static java.util.Locale.ENGLISH;
import static numbersinwords.Constants.*;

import java.text.NumberFormat;

public class NumberToWordsTransformer {
	private final long nSum;
	private final String sGender;
	private final String sCase;

	private final static String comma = ",";
	private final static long oneThousand = 1000L;


	NumberToWordsTransformer(long nSum, String sGender, String sCase) {
		this.nSum = nSum;
		this.sGender = sGender;
		this.sCase = sCase;
	}

	public String transform(){
		if (nSum == 0L) return "ноль ";
		long sum = nSum;

		int length = NumberFormat.getInstance(ENGLISH).format(sum).split(comma).length - 1;
		long divisor = (long)Math.pow(oneThousand, length);

		StringBuilder result = new StringBuilder();
		for (; length >= 0; length--) {
			int res = (int) (sum / divisor);
			sum = sum % divisor;

			result.append(calcDigit(res, length));
			result.append(calcPower(res, length));

			divisor = divisor / oneThousand;
		}
		result.deleteCharAt(result.length() - 1);//Удаляется последний пробел
		return result.toString();
	}

	private String calcDigit(int res, int length){
		final int thousandsMark = 1;

		StringBuilder result = new StringBuilder();
		if (res == 0 && length == 0) {
			result.append(Constants.POWER[length][singularIndex]);
		} else {
			if (res >= 100) {
				result.append(Constants.DIGIT[res / 100][hundredsIndex]);
				res %= 100;
			}
			if (res >= 20) {
				result.append(Constants.DIGIT[res / 10][decadesIndex]);
				res %= 10;
			}
			if (res >= 10) {
				result.append(Constants.DIGIT[res - 10][from11to20Index]);
			} else if (res >= 1){
				result.append(Constants.DIGIT[res][length == thousandsMark ? forThousandsIndex : forOthersIndex]);
			}
		}
		return result.toString();
	}

	private String calcPower(int res, int length){
		switch (res) {
			case 1:
				return Constants.POWER[length][singularIndex];
			case 2:
			case 3:
			case 4:
				return Constants.POWER[length][from2to4Index];
			default:
				return Constants.POWER[length][from5to9Index];
		}
	}
}
