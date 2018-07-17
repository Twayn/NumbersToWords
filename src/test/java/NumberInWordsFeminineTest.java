import static java.util.Map.entry;
import static java.util.Map.ofEntries;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsFeminineTest {

	private Map<Long, String> feminineNormativeValues = ofEntries(
		entry(6L, "шесть"),
		entry(42L, "сорок две"),
		entry(201L, "двести одна"),
		entry(662L, "шестьсот шестьдесят две"),
		entry(1001L, "одна тысяча одна"),
		entry(66_302L, "шестьдесят шесть тысяч триста две"),
		entry(3_165_334L, "три миллиона сто шестьдесят пять тысяч триста тридцать четыре")
	);

	private Map<Long, String> feminineGenetiveValues = ofEntries(
		entry(1L, "одной"),
		entry(2L, "двух"),
		entry(12L, "двенадцати"),
		entry(31L, "тридцати одной"),
		entry(13213L, "тринадцати тысяч двухсот тринадцати"),
		entry(123_567L, "ста двадцати трех тысяч пятисот шестидесяти семи"),
		entry(7_664_000_502L, "семи миллиардов шестисот шестидесяти четырех миллионов пятисот двух"),
		entry(888_888_888_991L, "восьмисот восьмидесяти восьми миллиардов восьмисот восьмидесяти восьми миллионов восьмисот восьмидесяти восьми тысяч девятисот девяноста одной")
	);

	private Map<Long, String> feminineDativeValues = ofEntries(
		entry(0L, "нолю"),
		entry(3L, "трем"),
		entry(31L, "тридцати одной"),
		entry(1101L, "одной тысяче ста одной"),
		entry(444L, "четыремстам сорока четырем"),
		entry(1111L, "одной тысяче ста одиннадцати"),
		entry(63_962L, "шестидесяти трем тысячам девятистам шестидесяти двум"),
		entry(123_567L, "ста двадцати трем тысячам пятистам шестидесяти семи"),
		entry(17_551_004_001L, "семнадцати миллиардам пятистам пятидесяти одному миллиону четырем тысячам одной")
	);

	private Map<Long, String> feminineAccusativeValues = ofEntries(
		entry(0L, "ноль"),
		entry(1L, "одну"),
		entry(14L, "четырнадцать"),
		entry(92L, "девяносто две"),
		entry(1902L, "одну тысячу девятьсот две"),
		entry(12203L, "двенадцать тысяч двести три"),
		entry(73_165_332L, "семьдесят три миллиона сто шестьдесят пять тысяч триста тридцать две"),
		entry(800_400_001_030L, "восемьсот миллиардов четыреста миллионов одну тысячу тридцать")
	);

	private Map<Long, String> feminineInstrumentalValues = ofEntries(
		entry(0L, "нолем"),
		entry(3L, "тремя"),
		entry(13L, "тринадцатью"),
		entry(22L, "двадцатью двумя"),
		entry(31L, "тридцатью одной"),
		entry(85L, "восьмьюдесятью пятью"),
		entry(471L, "четырьмястами семьюдесятью одной"),
		entry(8032L, "восемью тысячами тридцатью двумя"),
		entry(91_735L, "девяноста одной тысячей семьюстами тридцатью пятью"),
		entry(454_976L, "четырьмястами пятьюдесятью четырьмя тысячами девятьюстами семьюдесятью шестью"),
		entry(7_895_441L, "семью миллионами восемьюстами девяноста пятью тысячами четырьмястами сорока одной")
	);

	private Map<Long, String> femininePrepositionalValues = ofEntries(
		entry(0L, "о ноле"),
		entry(1L, "об одной"),
		entry(167L, "о ста шестидесяти семи"),
		entry(1101L, "об одной тысяче ста одной"),
		entry(65_841L, "о шестидесяти пяти тысячах восьмистах сорока одной"),
		entry(122_964L, "о ста двадцати двух тысячах девятистах шестидесяти четырех"),
		entry(1_698_300L, "об одном миллионе шестистах девяноста восьми тысячах трехстах"),
		entry(664_789_197L, "о шестистах шестидесяти четырех миллионах семистах восьмидесяти девяти тысячах ста девяноста семи")
	);

	@Test
	public void feminineNominativeTest(){
		for (Map.Entry<Long, String> entry : feminineNormativeValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.NOMINATIVE);
		}
	}

	@Test
	public void feminineGenetiveTest(){
		for (Map.Entry<Long, String> entry : feminineGenetiveValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.GENITIVE);
		}
	}

	@Test
	public void feminineDativeTest(){
		for (Map.Entry<Long, String> entry : feminineDativeValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.DATIVE);
		}
	}

	@Test
	public void feminineAccusativeTest(){
		for (Map.Entry<Long, String> entry : feminineAccusativeValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.ACCUSATIVE);
		}
	}

	@Test
	public void feminineInstrumentalTest(){
		for (Map.Entry<Long, String> entry : feminineInstrumentalValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.INSTRUMENTAL);
		}
	}

	@Test
	public void femininePrepositionalTest(){
		for (Map.Entry<Long, String> entry : femininePrepositionalValues.entrySet()) {
			testNumberToWord(entry, INumberInWords.PREPOSITIONAL);
		}
	}

	private void testNumberToWord(Map.Entry<Long, String> entry, String sCase){
		NumberInWords numberInWords = new NumberInWords();
		String sNumber = numberInWords.sumProp(entry.getKey(), INumberInWords.FEMININE, sCase);
		Assert.assertEquals(entry.getValue(), sNumber);
	}
}