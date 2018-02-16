package bbelanger.web;

import java.lang.Math;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import bbelanger.domain.*;

/**
 * Controller class for URLs mapping to /fizzbuzz/
 * @author Benny Belanger
 *
 */
@RestController
public class FizzBuzzController {
	FizzBuzzChecker fizzBuzzChecker;
	
	public FizzBuzzController(){
		//build Chain of Responsibility for FizzBuzz Checkers
		fizzBuzzChecker = new FizzBuzzChecker();
		FizzChecker fizzChecker = new FizzChecker();
		BuzzChecker buzzChecker = new BuzzChecker();
		fizzChecker.setNextHandler(buzzChecker);
		fizzBuzzChecker.setNextHandler(fizzChecker);
	}
	
	/**
	 * Main Entry point for the service. Binds to /fizzbuzz/{number} will respond with 
	 * in a JSON format example {"FizzBuzz":[15],"Fizz":[3,6,9,12],"Buzz":[5,10]}
	 * 
	 * @param number takes in number as upper bound to execute FizzBuzzChecker on
	 * @return <code>FizzBuzzResponse</code> returns FizzBuzzResponse as a json representation
	 */
    @RequestMapping(value="/fizzbuzz/{number}",method=RequestMethod.GET,produces="application/json")
    @ResponseBody
    public FizzBuzzResponse index(@PathVariable("number") int number) {
    	//FizzBuzzResponse variable to store our result. 
    	FizzBuzzResponse result= new FizzBuzzResponse(); 

    	//Setting this boolean to output negative numbers, without effecting our core loop
    	boolean negative = false;
    	if(number < 0 ){
    		number = Math.abs(number);
    		negative = true;
    	}
    	
    	//Finally Do the real work and loop through given input 
    	for (int i = 1; i <= number; i++) {
    		String checkedResult = fizzBuzzChecker.processValue(i);
    		if(checkedResult != null){
    			//Could use ternary operator negative ? i*-1 : But not as readable
    			//Need to convert back to negative if that is what we received
    			int origionalValue= i;
    			if(negative){
    				origionalValue = i*-1;
    			}
    			//Storing the results in the response object.
    			result.addToReponse(checkedResult, origionalValue);
    		}
		}
    	//Respond with the Response object, SpringBoot will parse it to JSON using Jackson
        return result;
    }

}
