package bbelanger.domain;

/**
 * Abstract class that is an implementation of the
 * Chain of Responsibility design pattern.
 *
 * @author Benny Belanger
 */
public abstract class FizzBuzzChainHandler {
  
  /** Reference to the next Handler in the Chain **/
  protected FizzBuzzChainHandler nextHandler;

  /**
  * Getter for the String response from the implementing class
  * @return <code>String</code> value of the Response
  **/
  abstract protected String getRepsponse();

  /**
  * Checks if a given value agienst the inputed value
  * @param valueToCheck value that will be checked
  * @return <code>true</code> if the value passed all checks
  *         <code>false</code> if the value failed checks 
  **/
  abstract protected boolean checkValue(int valueToCheck);
  
  /**
  * Sets the reference to the next Handler in the Chain
  * @param next the next FizzBuzzChainHandler in the Chain of Responsibility
  **/
  public void setNextHandler(FizzBuzzChainHandler next){
    nextHandler = next;
  }

  /**
  * Processes the given value through the Chain until one member of the Chain 
  * successfully processes the value
  * @param  valueToCheck  value that will be processed
  * @return    <code>String</code> result from the FizzBuzzChainHandler that succeeded. 
  *            <code>null</code> if no part of the chain was successful
  **/
  public String processValue(int valueToCheck){
    if (checkValue(valueToCheck)){
      return getRepsponse();
    } else if (nextHandler != null){
      return nextHandler.processValue(valueToCheck);
    }
    return null;
  }

}
