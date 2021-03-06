package numbersinwords;

import java.util.List;

public class NumberInWords implements INumberInWords {
	private final static String TOO_BIG_ERR_MSG = "Обрабатываемое число должно быть меньше ";
	private final static String TOO_SMALL_ERR_MSG = "Обрабатываемое число должно быть больше ";
	private final static String GENDER_NOT_SPECIFIED = "Род не указан ";
	private final static String CASE_NOT_SPECIFIED = "Падеж не указан ";
	private final static String WRONG_GENDER = "Неверное значение пола: ";
	private final static String WRONG_CASE = "Неверное значение падежа: ";
	private final static String VALID_GENDERS_MSG = "Допустимые значения пола: ";
	private final static String VALID_CASES_MSG = "Допустимые значения падежа: ";
	private final static String DOT_WITH_WHITESPASE = ". ";

	private final static List<String> VALID_GENDERS = List.of(
			MASCULINE, FEMININE, NEUTER
	);
	private final static List<String> VALID_CASES = List.of(
			NOMINATIVE, GENITIVE, DATIVE, ACCUSATIVE, INSTRUMENTAL, PREPOSITIONAL
	);

	public String sumProp(final long nSum, final String sGender, final String sCase) {
		checkNumberValue(nSum);
		checkGenderValue(sGender);
		checkCaseValue(sCase);
		var transformer = new NumberToWordsTransformer(nSum, sGender, sCase);
		return transformer.transform();
	}

	private void checkNumberValue(final long nSum){
		if (nSum > MAX_INPUT_VALUE){
			throw new IllegalArgumentException(TOO_BIG_ERR_MSG + MAX_INPUT_VALUE);
		}

		if (nSum < MIN_INPUT_VALUE){
			throw new IllegalArgumentException(TOO_SMALL_ERR_MSG + MIN_INPUT_VALUE);
		}
	}

	private void checkGenderValue(final String sGender){
		if (sGender == null){
			throw new NullPointerException(GENDER_NOT_SPECIFIED);
		}

		if (!VALID_GENDERS.contains(sGender)) {
			throw new IllegalArgumentException(WRONG_GENDER + sGender + DOT_WITH_WHITESPASE + VALID_GENDERS_MSG + VALID_GENDERS);
		}
	}

	private void checkCaseValue(final String sCase){
		if (sCase == null){
			throw new NullPointerException(CASE_NOT_SPECIFIED);
		}

		if (!VALID_CASES.contains(sCase)) {
			throw new IllegalArgumentException(WRONG_CASE + sCase + DOT_WITH_WHITESPASE + VALID_CASES_MSG + VALID_CASES);
		}
	}
}
