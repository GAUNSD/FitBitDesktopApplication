package ca.uwo.csd.cs2212.team10;

//import RefreshTokens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.github.scribejava.apis.FitbitApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.model.*; //Request Verb
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.apis.service.FitbitOAuth20ServiceImpl;

import java.awt.Desktop;
import java.net.URI;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
//import org.apache.http.util.EntityUtils; //http-core-4.1.jar

public class Fitbit
{	
	/**
	 * THIS MAIN CAN BE MOVED ELSEWHERE, JUST HERE FOR TESTING
	 */
	public static void main (String [] args){
		
	try{
		//getDailySteps ("2016","01", "08");
		getDailyFloors ("2016","01", "08");

	} catch (JSONException e) { }
	
	}
	
	
	public static String parseDaily (String responseBody, String activity) throws JSONException{
		
		JSONObject obj= new JSONObject(responseBody);
		JSONArray jsonArray = obj.getJSONArray("activities-tracker-" + activity);
		String value= "";
	
		for (int i = 0; i < jsonArray.length(); i++) {
			
	     JSONObject childJSONObject = jsonArray.getJSONObject(i);
	     
	     value = childJSONObject.getString("value");
	     
		}
	
		return value;
	}
	
	
	
	public static void getDailyFloors (String year, String month, String day)throws JSONException {
		
		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/floors/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
		
		getAPI (requestUrl);
	}


	public static void getDailySteps (String year, String month, String day) throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/steps/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	
	}

	public static void getDailyCalories (String year, String month, String day)throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/calories/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}

	public static void getDailyDistance (String year, String month, String day) throws JSONException{

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/distance/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}


	public static void getDailySedentaryMins (String year, String month, String day)throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesSedentary/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}

		
		 
	public static void getDailyLightActivity(String year, String month, String day)throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesLightlyActive/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}


	public static void getDailyFairlyActivity(String year, String month, String day)throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesFairlyActive/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}	

	public static void getDailyVigorousActivity(String year, String month, String day)throws JSONException {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesVeryActive/date/";
		
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}
	
	
	public static void getBestAndLifetime() throws JSONException{
		
		String requestUrl = "https://api.fitbit.com/1/user/-/activities.json";
	
		getAPI (requestUrl);
		
	}

/**

public static void parseDailySteps(result) {

for (var i = 0; i < result.length; i++) { 
	 alert(result.activities-tracker-steps[0].value);
}
**/
	
	
	/**
	 * CALL ONE OF THE GETTER FROM "EXAMPLEMTHOD" CLASS AND USE THE URL YOU GET AND PASS
	 * IT INTO "GETAPI"...
	 */
	public static void getAPI (String requestUrl)throws JSONException
	{
		String jsonResult = RefreshTokens.getTokens(requestUrl); 
		
		String daily = parseDaily(jsonResult, "floors");
       
		//String jsonResult = response.getBody();
		
		/*JSONObject obj= new JSONObject(jsonResult);
		JSONArray jsonArray = obj.getJSONArray("activities-tracker-floors");
		String value="";
		
		for (int i = 0; i < jsonArray.length(); i++) 
		{
		     JSONObject childJSONObject = jsonArray.getJSONObject(i);
		     value = childJSONObject.getString("value");
		}
		*/
		System.out.println("Value is " + daily);
	
		
		/**String jsonResult2 = response.getBody();
		
		JSONObject obj2= new JSONObject(jsonResult2);
		JSONArray jsonArray2 = obj2.getJSONArray("activities-tracker-steps");
		String value2="";
		
		for (int i = 0; i < jsonArray2.length(); i++) 
		{
		     JSONObject childJSONObject = jsonArray2.getJSONObject(i);
		     value2 = childJSONObject.getString("value");
		}
		
		System.out.println("Value is " + value2); **/
		

			}
}
