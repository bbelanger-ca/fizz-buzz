package bbelanger.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzChainHandlerTest {
	//We just need to check the chain of responsibility not all of it's internal components
	static final int UPPER_VALUE = 20;
	static final String FIZZ="Fizz";
	static final String BUZZ="Buzz";
	static final String FIZZBUZZ="FizzBuzz";
	
	@Test
	public void processValueTest() {
		FizzBuzzChecker fizzBuzzChecker = new FizzBuzzChecker();
		FizzChecker fizzChecker = new FizzChecker();
		BuzzChecker buzzChecker = new BuzzChecker();
		fizzChecker.setNextHandler(buzzChecker);
		fizzBuzzChecker.setNextHandler(fizzChecker);
		
		String result = "";
		for (int i = 1; i < UPPER_VALUE; i++) {
			result = fizzBuzzChecker.processValue(i);
			if (i % 3 == 0 && i % 5 == 0){
				assertEquals(FIZZBUZZ,result );
			} else if ( i % 5 == 0){
				assertEquals(BUZZ,result );
			} else if (i % 3 == 0){
				assertEquals(FIZZ,result );
			} else{
				assertNull(result);
			}
		}
		
	}

}
