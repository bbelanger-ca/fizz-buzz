package bbelanger.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuzzCheckerTest {

	static final int UPPER_VALUE = Integer.MAX_VALUE;

	@Test
	public void checkValueTest() {
		BuzzChecker buzzChecker = new BuzzChecker();
		boolean result = false;
		for (int i = 1; i < UPPER_VALUE; i++) {
			result = buzzChecker.checkValue(i);
			if (i % 5 == 0){
				assertTrue(result);
			} else{
				assertFalse(result);
			}
		}
	}

}
