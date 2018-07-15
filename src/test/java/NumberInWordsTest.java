import org.junit.Assert;
import org.junit.Test;

public class NumberInWordsTest {
	@Test
	public void oneThousandAndOneMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String oneThousandAndOne = numberInWords.sumProp(1001L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("одна тысяча один", oneThousandAndOne);
	}

	@Test
	public void sixMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String six = numberInWords.sumProp(6L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("шесть", six);
	}

	@Test
	public void twelveMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String twelve = numberInWords.sumProp(12L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("двенадцать", twelve);
	}

	@Test
	public void twoHundredAndSeventeenMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String twoHundredAndSeventeen = numberInWords.sumProp(217L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("двести семнадцать", twoHundredAndSeventeen);
	}
}
