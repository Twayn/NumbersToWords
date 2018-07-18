package numbersinwords;

public interface INumberInWords {
	long MAX_INPUT_VALUE = 999_999_999_999L;
	long MIN_INPUT_VALUE = 0L;

	/*Рода*/
	String MASCULINE = "M";
	String FEMININE = "Ж";
	String NEUTER = "С";

	/*Падежи*/
	String NOMINATIVE = "И";
	String GENITIVE = "Р";
	String DATIVE = "Д";
	String ACCUSATIVE = "В";
	String INSTRUMENTAL = "Т";
	String PREPOSITIONAL = "П";

	/**
	 * Функция преобразования целого числа в строку прописью.
	 * @param nSum целое число менее триллиона (максимум 999 999 999 999)
	 * @param sGender род ("М"-мужской, "Ж"-женский, "С"-средний)
	 * @param sCase падеж ("И"-именительный, …, "П"-предложный)
	 * @return строка прописью от параметра nSum
	 */
	String sumProp(long nSum, String sGender, String sCase);
}
