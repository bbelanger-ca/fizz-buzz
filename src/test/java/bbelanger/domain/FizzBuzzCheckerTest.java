package bbelanger.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzCheckerTest {

	static final int UPPER_VALUE = Integer.MAX_VALUE;

	@Test
	public void checkValueTest() {
		FizzBuzzChecker fizzBuzzChecker = new FizzBuzzChecker();
		boolean result = false;
		for (int i = 1; i < UPPER_VALUE; i++) {
			result = fizzBuzzChecker.checkValue(i);
			if (i % 3 == 0 && i % 5 == 0){
				assertTrue(result);
			} else{
				assertFalse(result);
			}
		}
	}
}
