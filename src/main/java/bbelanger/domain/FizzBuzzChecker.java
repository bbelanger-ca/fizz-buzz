package bbelanger.domain;

/**
 * Concrete class that is an implementation of the
 * Chain of Responsibility design pattern.
 * Checks if values processed are divisible by 3 and 5.
 *
 * @author Benny Belanger
 */
public class FizzBuzzChecker extends FizzBuzzChainHandler {
  private static final String RESPONSE = "FizzBuzz";
  protected FizzBuzzChainHandler nextHandler;
  
  @Override
  protected boolean checkValue(int valueToCheck){
    boolean result = false;
    if (valueToCheck % 3 == 0 && valueToCheck % 5 == 0) {
      result = true;
    }
    return result;
  }

  @Override
  protected String getRepsponse() {
    return RESPONSE;
  }


}
