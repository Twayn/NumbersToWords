import org.junit.Assert;
import org.junit.Test;

public class NumberInWordsTest {
	@Test
	public void OneThousandMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String oneThousand = numberInWords.sumProp(1000L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("одна тысяча", oneThousand);
	}

	@Test
	public void SixMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String six = numberInWords.sumProp(6L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("шесть", six);
	}

	@Test
	public void TwelveMasculineNominativeTest(){
		NumberInWords numberInWords = new NumberInWords();
		String twelve = numberInWords.sumProp(6L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
		Assert.assertEquals("двенадцать", twelve);
	}
}
