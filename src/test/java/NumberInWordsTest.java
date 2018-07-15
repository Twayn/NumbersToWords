import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsTest {

	private Map<Long, String> normativeMasculineNumberValues = new LinkedHashMap<Long, String>(){{
		put(6L, "шесть");
		put(12L, "двенадцать");
		put(217L, "двести семнадцать");
		put(1001L, "одна тысяча один");
		put(66300L, "шестьдесят шесть тысяч триста");
		put(3165334L, "три миллиона сто шестьдесят пять тысяч триста тридцать четыре");
		put(429786218412L, "четыреста двадцать девять миллиардов семьсот восемьдесят шесть миллионов двести восемнадцать тысяч четыреста двенадцать");
	}};

	@Test
	public void MasculineNominativeTest(){
		normativeMasculineNumberValues.entrySet().forEach((entry)->
				testNumberToWord(entry, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE));
	}

	private void testNumberToWord(Map.Entry<Long, String> entry, String sGender, String sCase){
		NumberInWords numberInWords = new NumberInWords();
		String sNumber = numberInWords.sumProp(entry.getKey(), sGender, sCase);
		Assert.assertEquals(entry.getValue(), sNumber);
	}
}
