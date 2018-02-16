package bbelanger.domain;

/**
 * Concrete class that is an implementation of the
 * Chain of Responsibility design pattern.
 * Checks if values processed are divisible by 3.
 *
 * @author Benny Belanger
 */
public class FizzChecker extends FizzBuzzChainHandler {
  private static final String RESPONSE = "Fizz";
  protected FizzBuzzChainHandler nextHandler;

  @Override
  protected boolean checkValue(int valueToCheck){
    boolean result = false;
    if (valueToCheck % 3 == 0) {
      result = true;
    }
    return result;
  }

  @Override
  protected String getRepsponse() {
    return RESPONSE;
  }

}
