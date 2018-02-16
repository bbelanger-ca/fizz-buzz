package bbelanger.web;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * Response object to hold FizzBuzz results.
 * Object will be used to respond in a JSON format. 
 * Example: {"FizzBuzz":[15],"Fizz":[3,6,9,12],"Buzz":[5,10]}
 * @author Benny Belanger
 *
 */
public class FizzBuzzResponse {
	HashMap<String, ArrayList<Integer>> resp = new HashMap<String, ArrayList<Integer>>();
	
	@JsonValue
	public HashMap<String, ArrayList<Integer>> getResp() {
		return resp;
	}

	public void setResp(HashMap<String, ArrayList<Integer>> resp) {
		this.resp = resp;
	}

	public void addToReponse(String key, int value){
		if (resp.get(key) == null){
			resp.put(key, new ArrayList<Integer>());
		}
		resp.get(key).add(value);
	}
}
