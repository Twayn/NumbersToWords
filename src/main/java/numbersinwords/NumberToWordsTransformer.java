package numbersinwords;

import static numbersinwords.Constants.*;
import static numbersinwords.INumberInWords.ACCUSATIVE;
import static numbersinwords.INumberInWords.DATIVE;
import static numbersinwords.INumberInWords.FEMININE;
import static numbersinwords.INumberInWords.GENITIVE;
import static numbersinwords.INumberInWords.INSTRUMENTAL;
import static numbersinwords.INumberInWords.NEUTER;
import static numbersinwords.INumberInWords.NOMINATIVE;
import static numbersinwords.INumberInWords.PREPOSITIONAL;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**Отвечает за преобразование числа в его словесное представление по заданным правилам*/
class NumberToWordsTransformer {
	private final long nSum;
	private final String sCase;
	private final String[][] digit;
	private final String[][] power;
	private final Map<String, String> declineByGenders;

	NumberToWordsTransformer(long nSum, String sGender, String sCase) {
		this.nSum = nSum;
		this.sCase = sCase;
		switch (sCase){
			case NOMINATIVE:
				this.digit = Constants.DIGIT_NOMINATIVE;
				this.power = Constants.POWER_NOMINATIVE;
				break;
			case GENITIVE:
				this.digit = Constants.DIGIT_GENITIVE;
				this.power = Constants.POWER_GENITIVE;
				break;
			case DATIVE:
				this.digit = Constants.DIGIT_DATIVE;
				this.power = Constants.POWER_DATIVE;
				break;
			case ACCUSATIVE:
				this.digit = Constants.DIGIT_ACCUSATIVE;
				this.power = Constants.POWER_ACCUSATIVE;
				break;
			case INSTRUMENTAL:
				this.digit = Constants.DIGIT_INSTRUMENTAL;
				this.power = Constants.POWER_INSTRUMENTAL;
				break;
			case PREPOSITIONAL:
				this.digit = Constants.DIGIT_PREPOSITIONAL;
				this.power = Constants.POWER_PREPOSITIONAL;
				break;
			default: throw new RuntimeException("Неподдерживаемый падеж: " + sCase);
		}
		declineByGenders = getDeclineByGenders(sGender, sCase);
	}

	/**
	 * Если требуется, загружает и возращает карту с необходимыми склонениями
	 * @param sGender пол для поиска карты
	 * @param sCase падеж для поиска карты
	 * @return подходящую карту, если она нашлась, иначе null
	 */
	private Map<String, String> getDeclineByGenders(String sGender, String sCase){
		if (sGender.equals(FEMININE)) {
			return FOR_FEMININE.get(sCase);
		} else if (sGender.equals(NEUTER)){
			if (sCase.equals(NOMINATIVE) || sCase.equals(ACCUSATIVE)) return N_NOMINATIVE_AND_ACCUSATIVE;
		}
		return null;
	}

	/**
	 * Считает словесное представление числа {@link NumberToWordsTransformer#nSum}.
	 * @return словесное представление {@link NumberToWordsTransformer#nSum}
	 */
	String transform() {
		if (nSum == 0L) return FOR_ZERO.get(sCase);

		var result = new StringBuilder();

		/*Разделить число на группы по 3 разряда и обработать каждую*/
		var triplets = Arrays.asList(String.format("%,d", nSum).split(","));
		var size = triplets.size();
		for (var trio : triplets) {
			result.append(calcVerbalFrom(Integer.valueOf(trio), --size));
		}

		/*Удалить последний пробел*/
		result.deleteCharAt(result.length() - 1);

		return declineByGenders(prefixForInstrumental(result.toString()));
	}

	/**
	 * Если падеж предложный к входной строке добавляется соответсвующий префикс.
	 * @param source строка для добавления префикса.
	 * @return строка с префиксом или нет в зависимости от падежа.
	 */
	private String prefixForInstrumental(final String source){
		if (sCase.equals(PREPOSITIONAL)){
			if (source.startsWith("о")){
				return "об " + source;
			} else return "о " + source;
		}
		return source;
	}

	/**
	 * Склонение числительных по родам.
	 * Если строка оканчивается на число один или два в разных формах
	 * и запрошено сконение по родам, то последнее слово заменяется на необходимое.
	 * @param source входная строка для склонения.
	 * @return строка преобразованная в зависимости от необходимости склонения.
	 */
	private String declineByGenders(final String source){
		if (declineByGenders != null){
			String[] split = source.split(" ");
			String lastWord = split[split.length - 1];

			if (IS_NEED_TO_DECLINE.contains(lastWord)){
				split[split.length - 1] = declineByGenders.get(lastWord);
			}

			return Arrays.stream(split).collect(Collectors.joining(" "));
		}
		return source;
	}

	/**
	 * Считает словесное представление числа со степенью в правильном падеже.
	 * Пример: calcVerbalFrom(22, 1) для именительно падежа вернет "двадцать две тысячи".
	 * @param trio число от 0 до 999.
	 * @param power степень (1 - тысячи, 2 - миллионы ...).
	 * @return словесная форма числа со степенью.
	 */
	private String calcVerbalFrom(final int trio, final int power){
		final var thousands = 1;
		var result = new StringBuilder();

		var ones = trio % 10;
		var decades = trio/10 % 10;
		var hundreds = trio/100 % 10;

		var key = trio;//Используется для поиска по словарю степеней
		if (trio > 0) {
			if (hundreds > 0) { //Если первый разряд не 0 (100-999)
				result.append(digit[hundreds][hundredsIndex]);
				key %= 100;
			}
			if (decades > 1) { //Если второй разряд больше 1 (X20-X99)
				result.append(digit[decades][decadesIndex]);
				key %= 10;
			}
			if (decades == 1) { //Если второй разряд 1 (числа X10-X19)
				result.append(digit[ones][from11to20Index]);
			} else { //Если второй разряд 0 (числа X01-X09)
				result.append(digit[ones][power == thousands ? forThousandsIndex : forOthersIndex]);
			}

			result.append(calcPower(key, power));
		}
		return result.toString();
	}

	/**
	 * Счтает словесное представление показателя степени в правильном падеже.
	 * @param key ключ для поиска по словарю (1-19)
	 * @param power степень (1 - тысячи, 2 - миллионы ...)
	 * @return показатель степени в словесной форме.
	 */
	private String calcPower(final int key, final int power){
		switch (key) {
			case 1:
				return this.power[power][singularIndex];
			case 2:
			case 3:
			case 4:
				return this.power[power][from2to4Index];
			default:
				return this.power[power][othersIndex];
		}
	}
}