package bbelanger.domain;

/**
 * Concrete class that is an implementation of the
 * Chain of Responsibility design pattern.
 * Checks if values processed are divisible by 5.
 *
 * @author Benny Belanger
 */
public class BuzzChecker extends FizzBuzzChainHandler {
	
  /**
  * RESPONSE "Buzz" static string for the response of this class
  **/
  private static final String RESPONSE = "Buzz";
  protected FizzBuzzChainHandler nextHandler;

  @Override
  protected boolean checkValue(int valueToCheck){
    boolean result = false;
    if (valueToCheck % 5 == 0) {
      result = true;
    }
    return result;
  }
  
  @Override
  protected String getRepsponse() {
    return RESPONSE;
  }


}
