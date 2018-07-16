import org.junit.Test;

import numbersinwords.INumberInWords;
import numbersinwords.NumberInWords;

public class NumberInWordsExceptionTest {
	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsNumberTooSmallException(){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(-100, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsNumberTooBigException(){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(1_000_000_000_000L, INumberInWords.MASCULINE, INumberInWords.NOMINATIVE);
	}

	@Test(expected = NullPointerException.class)
	public void NumberInWordsNullGenderException (){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(1, null, INumberInWords.NOMINATIVE);
	}

	@Test(expected = NullPointerException.class)
	public void NumberInWordsNullCaseException (){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(1, INumberInWords.MASCULINE, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsWrongGenderException (){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(1, "wrong", INumberInWords.NOMINATIVE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void NumberInWordsWrongCaseException (){
		var numberInWords = new NumberInWords();
		numberInWords.sumProp(1, INumberInWords.MASCULINE, "wrong");
	}
}
