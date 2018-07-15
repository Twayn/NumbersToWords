import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsExceptionTest {
	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsNumberTooSmallException(){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(-100, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsNumberTooBigException(){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(1_000_000_000_000L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
	}

	@Test(expected = NullPointerException.class)
	public void NumberInWordsNullGenderException (){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(1, null, INumberInWords.NOMINATIVE);
	}

	@Test(expected = NullPointerException.class)
	public void NumberInWordsNullCaseException (){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(1, INumberInWords.MASCULINE, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsWrongGenderException (){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(1, "wrong", INumberInWords.NOMINATIVE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsWrongCaseException (){
		NumberInWords numberInWords = new NumberInWords();
		numberInWords.sumProp(1, INumberInWords.MASCULINE, "wrong");
	}
}
