import static java.util.Map.entry;
import static java.util.Map.ofEntries;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsNeuterTest {

	private Map<Long, String> neuterNormativeValues = ofEntries(
		entry(0L, "ноль"),
		entry(1L, "одно"),
		entry(12L, "двенадцать"),
		entry(217L, "двести семнадцать"),
		entry(662L, "шестьсот шестьдесят два"),
		entry(1001L, "одна тысяча одно"),
		entry(25_301L, "двадцать пять тысяч триста одно"),
		entry(3_165_334L, "три миллиона сто шестьдесят пять тысяч триста тридцать четыре"),
		entry(42_931_248L, "сорок два миллиона девятьсот тридцать одна тысяча двести сорок восемь"),
		entry(7_664_010_500L, "семь миллиардов шестьсот шестьдесят четыре миллиона десять тысяч пятьсот"),
		entry(429_786_218_412L, "четыреста двадцать девять миллиардов семьсот восемьдесят шесть миллионов двести восемнадцать тысяч четыреста двенадцать")
	);

	private Map<Long, String> neuterGenetiveValues = ofEntries(
		entry(0L, "ноля"),
		entry(1L, "одного"),
		entry(6L, "шести"),
		entry(12L, "двенадцати"),
		entry(31L, "тридцати одного"),
		entry(256L, "двухсот пятидесяти шести"),
		entry(813L, "восьмисот тринадцати"),
		entry(1001L, "одной тысячи одного"),
		entry(13213L, "тринадцати тысяч двухсот тринадцати"),
		entry(123_567L, "ста двадцати трех тысяч пятисот шестидесяти семи"),
		entry(43_931_248L, "сорока трех миллионов девятисот тридцати одной тысячи двухсот сорока восьми"),
		entry(7_684_000_500L, "семи миллиардов шестисот восьмидесяти четырех миллионов пятисот")
	);

	private Map<Long, String> neuterDativeValues = ofEntries(
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
		entry(11_551_040_013L, "одиннадцати миллиардам пятистам пятидесяти одному миллиону сорока тысячам тринадцати")
	);

	private Map<Long, String> neuterAccusativeValues = ofEntries(
		entry(0L, "ноль"),
		entry(1L, "одно"),
		entry(14L, "четырнадцать"),
		entry(99L, "девяносто девять"),
		entry(111L, "сто одиннадцать"),
		entry(1905L, "одну тысячу девятьсот пять"),
		entry(12201L, "двенадцать тысяч двести одно"),
		entry(628_765L, "шестьсот двадцать восемь тысяч семьсот шестьдесят пять"),
		entry(73_165_334L, "семьдесят три миллиона сто шестьдесят пять тысяч триста тридцать четыре"),
		entry(1_321_789_451L, "один миллиард триста двадцать один миллион семьсот восемьдесят девять тысяч четыреста пятьдесят одно"),
		entry(800_400_001_031L, "восемьсот миллиардов четыреста миллионов одну тысячу тридцать одно")
	);

	private Map<Long, String> neuterInstrumentalValues = ofEntries(
		entry(0L, "нолем"),
		entry(9L, "девятью"),
		entry(13L, "тринадцатью"),
		entry(90L, "девяноста"),
		entry(263L, "двумястами шестьюдесятью тремя"),
		entry(479L, "четырьмястами семьюдесятью девятью"),
		entry(7038L, "семью тысячами тридцатью восьмью"),
		entry(91_735L, "девяноста одной тысячей семьюстами тридцатью пятью"),
		entry(454_976L, "четырьмястами пятьюдесятью четырьмя тысячами девятьюстами семьюдесятью шестью"),
		entry(7_995_446L, "семью миллионами девятьюстами девяноста пятью тысячами четырьмястами сорока шестью"),
		entry(212_101_454_159L, "двумястами двенадцатью миллиардами ста одним миллионом четырьмястами пятьюдесятью четырьмя тысячами ста пятьюдесятью девятью")
	);

	private Map<Long, String> neuterPrepositionalValues = ofEntries(
		entry(0L, "о ноле"),
		entry(1L, "об одном"),
		entry(7L, "о семи"),
		entry(67L, "о шестидесяти семи"),
		entry(783L, "о семистах восьмидесяти трех"),
		entry(1111L, "об одной тысяче ста одиннадцати"),
		entry(65_841L, "о шестидесяти пяти тысячах восьмистах сорока одном"),
		entry(132_964L, "о ста тридцати двух тысячах девятистах шестидесяти четырех"),
		entry(1_455_544L, "об одном миллионе четырехстах пятидесяти пяти тысячах пятистах сорока четырех"),
		entry(167_958_156L, "о ста шестидесяти семи миллионах девятистах пятидесяти восьми тысячах ста пятидесяти шести"),
		entry(23_972_034_750L, "о двадцати трех миллиардах девятистах семидесяти двух миллионах тридцати четырех тысячах семистах пятидесяти")
	);

	@Test
	public void neuterNominativeTest(){
		neuterNormativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.NOMINATIVE));

	}

	@Test
	public void neuterGenitiveTest(){
		neuterGenetiveValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.GENITIVE));
	}

	@Test
	public void neuterDativeTest(){
		neuterDativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.DATIVE));
	}

	@Test
	public void neuterAccusativeTest(){
		neuterAccusativeValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.ACCUSATIVE));
	}

	@Test
	public void neuterInstrumentalTest(){
		neuterInstrumentalValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.INSTRUMENTAL));
	}

	@Test
	public void neuterPrepositionalTest(){
		neuterPrepositionalValues.entrySet().forEach((entry)->
			testNumberToWord(entry, INumberInWords.PREPOSITIONAL));

	}

	private void testNumberToWord(Map.Entry<Long, String> entry, String sCase){
		NumberInWords numberInWords = new NumberInWords();
		String sNumber = numberInWords.sumProp(entry.getKey(), INumberInWords.NEUTER, sCase);
		Assert.assertEquals(entry.getValue(), sNumber);
	}
}