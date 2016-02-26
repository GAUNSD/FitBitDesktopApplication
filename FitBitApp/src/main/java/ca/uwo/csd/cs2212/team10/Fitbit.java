package ca.uwo.csd.cs2212.team10;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * 
 * @author Pearson and Patrick
 * This class will be used to get information from Fitbit services
 * as well as calling for new tokens and saving data
 * Consists of: Heart Statistics, Best and Lifetime Statistics 
 */
public class Fitbit
{	
	/**
	 * THIS MAIN CAN BE MOVED ELSEWHERE, JUST HERE FOR TESTING
	 * @throws JSONException 
	 * @throws TokensException 
	 */
	public static void main (String [] args) throws JSONException, TokensException
	{
		getHeartActivity();
		getBestLifeActivity();
	
	}
	
	/**
	 * Best Statistics Call
	 * @return
	 * @throws JSONException
	 * @throws TokensException
	 */
	public static BestLifeStats getBestLifeActivity() throws JSONException, TokensException
	{
		//API requests
		String requestUrl = "https://api.fitbit.com/1/user/3WGW2P/activities.json";
		String jsonResult = RefreshTokens.getTokens(requestUrl);
		JSONObject object = new JSONObject(jsonResult);

		//get information via JSON
		JSONObject best = object.getJSONObject("best");
		JSONObject tracker = best.getJSONObject("tracker");
		
		//best distance
		JSONObject dist = tracker.getJSONObject("distance");
		double valueDist = dist.getDouble("value");
		String dateDist = dist.getString("date");
		
		//best floors
		JSONObject floors = tracker.getJSONObject("floors");
		double valueFloors = floors.getDouble("value");
		String dateFloors = floors.getString("date");
		
		//best steps
		JSONObject steps = tracker.getJSONObject("steps");
		Long valueSteps = steps.getLong("value");
		String dateSteps = steps.getString("date");
		
		//Lifetime statistics
		JSONObject lifetime = object.getJSONObject("lifetime");
		JSONObject total = lifetime.getJSONObject("total");
		double lifeDist = total.getDouble("distance");
		double lifeFloors = total.getInt("floors");
		long lifeSteps = total.getInt("steps");
		
		return new BestLifeStats(valueDist, dateDist, valueFloors, dateFloors, valueSteps, dateSteps, lifeDist, lifeFloors, lifeSteps);
	}

	/**
	 * Heart Rate Statistics Call
	 * @return
	 * @throws JSONException
	 * @throws TokensException
	 * Gathers information for Heart Statistics
	 */
	public static HeartStats getHeartActivity() throws JSONException, TokensException
	{
		
		///////////NEED TO ADD IN DATE TO DATE FOR URL////////////////////
		
		//API Request
		String requestUrl = "https://api.fitbit.com/1/user/3WGW2P/activities/heart/date/today/1d.json";
		String jsonResult = RefreshTokens.getTokens(requestUrl);
		
		//get information via JSON 
		JSONObject object = new JSONObject(jsonResult);
		JSONArray activitiesHeart = object.getJSONArray("activities-heart");
		JSONObject heartZones = activitiesHeart.getJSONObject(0);
		JSONObject value = heartZones.getJSONObject("value");
		JSONArray heartRateZones = value.getJSONArray("heartRateZones");
		
		//assign the values
		int outOfRange = heartRateZones.getJSONObject(0).getInt("minutes");
		int fatBurn = heartRateZones.getJSONObject(1).getInt("minutes");
		int cardio = heartRateZones.getJSONObject(2).getInt("minutes");
		int peak = heartRateZones.getJSONObject(3).getInt("minutes");
		
		//int restHeartRate = value.getInt("restingHeartRate");
		int restHeartRate = 70;
		
		return new HeartStats(outOfRange, fatBurn, cardio, peak, restHeartRate);
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
	
	/**
	 * CALL ONE OF THE GETTER FROM "EXAMPLEMTHOD" CLASS AND USE THE URL YOU GET AND PASS
	 * IT INTO "GETAPI"...
	 */
	public static void getAPI (String requestUrl)throws JSONException
	{

	}
}
