import static java.util.Map.entry;
import static java.util.Map.ofEntries;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsMasculineTest {

	private Map<Long, String> masculineNormativeValues = ofEntries(
		entry(0L, "ноль"),
		entry(6L, "шесть"),
		entry(12L, "двенадцать"),
		entry(217L, "двести семнадцать"),
		entry(662L, "шестьсот шестьдесят два"),
		entry(1001L, "одна тысяча один"),
		entry(66_300L, "шестьдесят шесть тысяч триста"),
		entry(3_165_334L, "три миллиона сто шестьдесят пять тысяч триста тридцать четыре"),
		entry(42_931_248L, "сорок два миллиона девятьсот тридцать одна тысяча двести сорок восемь"),
		entry(7_664_000_500L, "семь миллиардов шестьсот шестьдесят четыре миллиона пятьсот"),
		entry(429_786_218_412L, "четыреста двадцать девять миллиардов семьсот восемьдесят шесть миллионов двести восемнадцать тысяч четыреста двенадцать")
	);

	private Map<Long, String> masculineGenetiveValues = ofEntries(
		entry(0L, "ноля"),
		entry(1L, "одного"),
		entry(6L, "шести"),
		entry(12L, "двенадцати"),
		entry(31L, "тридцати одного"),
		entry(255L, "двухсот пятидесяти пяти"),
		entry(300L, "трехсот"),
		entry(511L, "пятисот одиннадцати"),
		entry(1001L, "одной тысячи одного"),
		entry(13213L, "тринадцати тысяч двухсот тринадцати"),
		entry(123_567L, "ста двадцати трех тысяч пятисот шестидесяти семи"),
		entry(42_931_248L, "сорока двух миллионов девятисот тридцати одной тысячи двухсот сорока восьми"),
		entry(7_664_000_500L, "семи миллиардов шестисот шестидесяти четырех миллионов пятисот"),
		entry(999_999_999_999L, "девятисот девяноста девяти миллиардов девятисот девяноста девяти миллионов девятисот девяноста девяти тысяч девятисот девяноста девяти")
	);

	private Map<Long, String> masculineDativeValues = ofEntries(
		entry(0L, "нолю"),
		entry(9L, "девяти"),
		entry(13L, "тринадцати"),
		entry(32L, "тридцати двум"),
		entry(871L, "восьмистам семидесяти одному"),
		entry(444L, "четыремстам сорока четырем"),
		entry(703L, "семистам трем"),
		entry(1111L, "одной тысяче ста одиннадцати"),
		entry(63_962L, "шестидесяти трем тысячам девятистам шестидесяти двум"),
		entry(123_567L, "ста двадцати трем тысячам пятистам шестидесяти семи"),
		entry(76_656_982L, "семидесяти шести миллионам шестистам пятидесяти шести тысячам девятистам восьмидесяти двум"),
		entry(17_551_004_010L, "семнадцати миллиардам пятистам пятидесяти одному миллиону четырем тысячам десяти")
	);

	private Map<Long, String> masculineAccusativeValues = ofEntries(
		entry(0L, "ноль"),
		entry(1L, "один"),
		entry(14L, "четырнадцать"),
		entry(99L, "девяносто девять"),
		entry(111L, "сто одиннадцать"),
		entry(1905L, "одну тысячу девятьсот пять"),
		entry(12203L, "двенадцать тысяч двести три"),
		entry(628_765L, "шестьсот двадцать восемь тысяч семьсот шестьдесят пять"),
		entry(73_165_334L, "семьдесят три миллиона сто шестьдесят пять тысяч триста тридцать четыре"),
		entry(1_321_789_456L, "один миллиард триста двадцать один миллион семьсот восемьдесят девять тысяч четыреста пятьдесят шесть"),
		entry(800_400_001_030L, "восемьсот миллиардов четыреста миллионов одну тысячу тридцать")
	);

	private Map<Long, String> masculineInstrumentalValues = ofEntries(
		entry(0L, "нолем"),
		entry(9L, "девятью"),
		entry(13L, "тринадцатью"),
		entry(22L, "двадцатью двумя"),
		entry(31L, "тридцатью одним"),
		entry(80L, "восьмьюдесятью"),
		entry(471L, "четырьмястами семьюдесятью одним"),
		entry(963L, "девятьюстами шестьюдесятью тремя"),
		entry(7030L, "семью тысячами тридцатью"),
		entry(91_735L, "девяноста одной тысячей семьюстами тридцатью пятью"),
		entry(454_976L, "четырьмястами пятьюдесятью четырьмя тысячами девятьюстами семьюдесятью шестью"),
		entry(7_895_446L, "семью миллионами восемьюстами девяноста пятью тысячами четырьмястами сорока шестью"),
		entry(112_101_454_158L, "ста двенадцатью миллиардами ста одним миллионом четырьмястами пятьюдесятью четырьмя тысячами ста пятьюдесятью восьмью")
	);

	private Map<Long, String> masculinePrepositionalValues = ofEntries(
		entry(0L, "о ноле"),
		entry(1L, "об одном"),
		entry(9L, "о девяти"),
		entry(67L, "о шестидесяти семи"),
		entry(783L, "о семистах восьмидесяти трех"),
		entry(1100L, "об одной тысяче ста"),
		entry(65_841L, "о шестидесяти пяти тысячах восьмистах сорока одном"),
		entry(132_964L, "о ста тридцати двух тысячах девятистах шестидесяти четырех"),
		entry(1_698_300L, "об одном миллионе шестистах девяноста восьми тысячах трехстах"),
		entry(654_789_197L, "о шестистах пятидесяти четырех миллионах семистах восьмидесяти девяти тысячах ста девяноста семи"),
		entry(22_472_034_750L, "о двадцати двух миллиардах четырехстах семидесяти двух миллионах тридцати четырех тысячах семистах пятидесяти")
	);

	@Test
	public void masculineNominativeTest(){
		 masculineNormativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.NOMINATIVE));
	}

	@Test
	public void masculineGenetiveTest(){
		 masculineGenetiveValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.GENITIVE));
	}

	@Test
	public void masculineDativeTest(){
		 masculineDativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.DATIVE));
	}

	@Test
	public void masculineAccusativeTest(){
		 masculineAccusativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.ACCUSATIVE));
	}

	@Test
	public void masculineInstrumentalTest(){
		 masculineInstrumentalValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.INSTRUMENTAL));
	}

	@Test
	public void masculinePrepositionalTest(){
		 masculinePrepositionalValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.PREPOSITIONAL));
	}

	private void testNumberToWord(Map.Entry<Long, String> entry, String sCase){
		NumberInWords numberInWords = new NumberInWords();
		String sNumber = numberInWords.sumProp(entry.getKey(), INumberInWords.MASCULINE, sCase);
		Assert.assertEquals(entry.getValue(), sNumber);
	}
}
