package bbelanger.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;

public class FizzCheckerTest {
	static final int UPPER_VALUE = Integer.MAX_VALUE;

	@Test
	public void checkValueTest() {
		FizzChecker fizzChecker = new FizzChecker();
		boolean result = false;
		for (int i = 1; i < UPPER_VALUE; i++) {
			result = fizzChecker.checkValue(i);
			if (i % 3 == 0){
				assertTrue(result);
			} else{
				assertFalse(result);
			}
		}
	}
}
