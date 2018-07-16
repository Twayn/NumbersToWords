import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsTest {

	private Map<Long, String> masculineNormativeValues = new LinkedHashMap<>() {{
		put(0L, "ноль");
		put(6L, "шесть");
		put(12L, "двенадцать");
		put(217L, "двести семнадцать");
		put(1001L, "одна тысяча один");
		put(66_300L, "шестьдесят шесть тысяч триста");
		put(3_165_334L, "три миллиона сто шестьдесят пять тысяч триста тридцать четыре");
		put(42_931_248L, "сорок два миллиона девятьсот тридцать одна тысяча двести сорок восемь");
		put(7_664_000_500L, "семь миллиардов шестьсот шестьдесят четыре миллиона пятьсот");
		put(429_786_218_412L, "четыреста двадцать девять миллиардов семьсот восемьдесят шесть миллионов двести восемнадцать тысяч четыреста двенадцать");
	}};

	private Map<Long, String> masculineGenetiveValues = new LinkedHashMap<>() {{
		put(0L, "ноля");
		put(1L, "одного");
		put(6L, "шести");
		put(12L, "двенадцати");
		put(31L, "тридцати одного");
		put(255L, "двухсот пятидесяти пяти");
		put(300L, "трехсот");
		put(1001L, "одной тысячи одного");
		put(123_567L, "ста двадцати трех тысяч пятисот шестидесяти семи");
		put(42_931_248L, "сорока двух миллионов девятисот тридцати одной тысячи двухсот сорока восьми");
		put(7_664_000_500L, "семи миллиардов шестисот шестидесяти четырех миллионов пятисот");
		put(999_999_999_999L, "девятисот девяноста девяти миллиардов девятисот девяноста девяти миллионов девятисот девяноста девяти тысяч девятисот девяноста девяти");
	}};

	private Map<Long, String> masculineDativeValues = new LinkedHashMap<>() {{
		put(0L, "нолю");
		put(9L, "девяти");
		put(13L, "тринадцати");
		put(32L, "тридцати двум");
		put(444L, "четыремстам сорока четырем");
		put(703L, "семистам трем");
		put(1111L, "одной тысяче ста одиннадцати");
		put(123_567L, "ста двадцати трем тысячам пятистам шестидесяти семи");
		put(76_656_982L, "семидесяти шести миллионам шестистам пятидесяти шести тысячам девятистам восьмидесяти двум");
		put(17_551_004_010L, "семнадцати миллиардам пятистам пятидесяти одному миллиону четырем тысячам десяти");
	}};

	private Map<Long, String> masculineAccusativeValues = new LinkedHashMap<>() {{
		put(1L, "один");
		put(14L, "четырнадцать");
		put(111L, "сто одиннадцать");
		put(1905L, "одну тысячу девятьсот пять");
		put(12203L, "двенадцать тысяч двести три");
		put(628_765L, "шестьсот двадцать восемь тысяч семьсот шестьдесят пять");
		put(73_165_334L, "семьдесят три миллиона сто шестьдесят пять тысяч триста тридцать четыре");
		put(1_321_789_456L, "один миллиард триста двадцать один миллион семьсот восемьдесят девять тысяч четыреста пятьдесят шесть");
		put(800_400_001_030L, "восемьсот миллиардов четыреста миллионов одну тысячу тридцать");
	}};

	private Map<Long, String> masculineInstrumentalValues = new LinkedHashMap<>() {{
		put(0L, "нолем");
		put(9L, "девятью");
		put(13L, "тринадцатью");
		put(22L, "двадцатью двумя");
		put(31L, "тридцатью одним");
		put(80L, "восьмьюдесятью");
		put(471L, "четырьмястами семьюдесятью одним");
		put(963L, "девятьюстами шестьюдесятью тремя");
		put(7030L, "семью тысячами тридцатью");
		put(91_735L, "девяноста одной тысячей семьюстами тридцатью пятью");
		put(454_976L, "четырьмястами пятьюдесятью четырьмя тысячами девятьюстами семьюдесятью шестью");
		put(7_895_446L, "семью миллионами восемьюстами девяноста пятью тысячами четырьмястами сорока шестью");
		put(112_101_454_158L, "ста двенадцатью миллиардами ста одним миллионом четырьмястами пятьюдесятью четырьмя тысячами ста пятьюдесятью восьмью");
	}};

	private Map<Long, String> masculinePrepositionalValues = new LinkedHashMap<>() {{
		put(0L, "о ноле");
		put(1L, "об одном");
		put(9L, "о девяти");
		put(67L, "о шестидесяти семи");
		put(1100L, "об одной тысяче ста");
		put(65_841L, "о шестидесяти пяти тысячах восьмистах сорока одном");
		put(132_964L, "о ста тридцати двух тысячах девятистах шестидесяти четырех");
		put(1_698_300L, "об одном миллионе шестистах девяноста восьми тысячах трехстах");
		put(654_789_197L, "о шестистах пятидесяти четырех миллионах семистах восьмидесяти девяти тысячах ста девяноста семи");
		put(22_472_034_750L, "о двадцати двух миллиардах четырехстах семидесяти двух миллионах тридцати четырех тысячах семистах пятидесяти");
	}};

	@Test
	public void masculineNominativeTest(){
		masculineNormativeValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE));
	}

	@Test
	public void masculineGenetiveTest(){
		masculineGenetiveValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.GENITIVE));
	}

	@Test
	public void masculineDativeTest(){
		masculineDativeValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.DATIVE));
	}

	@Test
	public void masculineAccusativeTest(){
		masculineAccusativeValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.ACCUSATIVE));
	}

	@Test
	public void masculineInstrumentalTest(){
		masculineInstrumentalValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.INSTRUMENTAL));
	}

	@Test
	public void masculinePrepositionalTest(){
		masculinePrepositionalValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.PREPOSITIONAL));
	}

	private void testNumberToWord(Map.Entry<Long, String> entry, String sGender, String sCase){
		NumberInWords numberInWords = new NumberInWords();
		String sNumber = numberInWords.sumProp(entry.getKey(), sGender, sCase);
		Assert.assertEquals(entry.getValue(), sNumber);
	}
}
