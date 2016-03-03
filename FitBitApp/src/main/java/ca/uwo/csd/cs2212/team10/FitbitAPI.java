package ca.uwo.csd.cs2212.team10;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class will be used to get information from Fitbit services
 * as well as calling for new tokens and saving data
 * Consists of: Heart Statistics, Best and Lifetime Statistics, Daily Statistics and Goals
 * @author Pearson and Patrick
 */
// renamed FitBit.java to FitBitAPI since we can't run this due a token problem. FitBitTest.java will be used for now. 
public class FitbitAPI
{	
	/*
	/*
	 * THIS MAIN CAN BE MOVED ELSEWHERE, JUST HERE FOR TESTING
	 * @throws JSONException 
	 * @throws TokensException 
	 *
	public static void main (String [] args) throws JSONException, TokensException
	{
		getHeartActivity("2016", "01", "29");
		getBestLifeActivity();
		getDailyActivity("2016", "01", "08");
	}
	*/
	
	/**
	 * Best Statistics Call
	 * @return BestLifeStats object containing all best life statistics data
	 * @throws JSONException method calls a JSON file which can throw this error
	 * @throws TokensException method uses tokens which can throw this error
	 */
	public static BestLifeStats getBestLifeActivity() throws JSONException, TokensException
	{
		//API requests
		String requestUrl = "https://api.fitbit.com/1/user/3WGW2P/activities.json";
		String jsonResult = RefreshTokens.getTokens(requestUrl);
		
		//get information via JSON string result
		JSONObject object = new JSONObject(jsonResult);
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
		
		//Return a new BestLifeStats object
		return new BestLifeStats(valueDist, dateDist, valueFloors, dateFloors, valueSteps, dateSteps, lifeDist, lifeFloors, lifeSteps);
	}

	/**
	 * Heart Rate Statistics Call
	 * Gathers information for Heart Statistics from a specified date
     * @param year String that contains the year of request
     * @param month String that contains the month of request
     * @param day String that contains the day of request
	 * @return HeartStats object containing all the heart rate data 
	 * @throws JSONException Method requests a JSON file that can throw this error
	 * @throws TokensException Method uses tokens to interface with API which can throw this error
	 */
	public static HeartStats getHeartActivity(String year, String month, String day) throws JSONException, TokensException
	{
		//API Request	
		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/heart/date/";
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
		String jsonResult = RefreshTokens.getTokens(requestUrl);
		
		//get information via JSON string result
		JSONObject object = new JSONObject(jsonResult);
		JSONArray activitiesHeart = object.getJSONArray("activities-heart");
		JSONObject heartZones = activitiesHeart.getJSONObject(0);
		JSONObject value = heartZones.getJSONObject("value");
		JSONArray heartRateZones = value.getJSONArray("heartRateZones");
		
		//assign the values for zones
		int outOfRange = heartRateZones.getJSONObject(0).getInt("minutes");
		int fatBurn = heartRateZones.getJSONObject(1).getInt("minutes");
		int cardio = heartRateZones.getJSONObject(2).getInt("minutes");
		int peak = heartRateZones.getJSONObject(3).getInt("minutes");
		
		//get the resting heart rate value
		int restHeartRate = value.getInt("restingHeartRate");
		
		//Return new HeartStats object
		return new HeartStats(outOfRange, fatBurn, cardio, peak, restHeartRate);
	}
		
	/**
	 * Daily Statistics Call
     * @param year String that contains the year of request
     * @param month String that contains the month of request
     * @param day String that contains the day of request
	 * @return DailyStats object containing all the daily statistics data
	 * @throws JSONException Method requests a JSON file that can throw this error
	 * @throws TokensException Method uses tokens to interface with API which can throw this error
	 */
	public static DailyStats getDailyActivity(String year, String month, String day) throws JSONException, TokensException
	{
		//API Request	
		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/date/";
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day + ".json";
		String jsonResult = RefreshTokens.getTokens(requestUrl);
		
		//get information via JSON string result
		JSONObject object = new JSONObject(jsonResult);
		JSONObject summary = object.getJSONObject("summary"); 
		JSONArray distances = summary.getJSONArray("distances");
		
		//Get the Daily Values of the 8 daily activities
		double distance = distances.getJSONObject(1).getDouble("distance");
		int calories = summary.getInt("caloriesOut");
		int floors = summary.getInt("floors");
		int steps = summary.getInt ("steps");
		int lightActiveMins = summary.getInt ("lightlyActiveMinutes");
		int fairlyActiveMins = summary.getInt ("fairlyActiveMinutes");
		int sedentaryMins = summary.getInt ("sedentaryMinutes");
		int veryActiveMins = summary.getInt ("veryActiveMinutes");
		
		//get the Daily Goal Values
		JSONObject goals = object.getJSONObject("goals");
		int activeMinGoals = goals.getInt("activeMinutes"); 
		int caloriesOutGoals = goals.getInt("caloriesOut");
		double distanceGoals = goals.getDouble("distance");
		int floorGoals = goals.getInt("floors");
		int stepGoals = goals.getInt("steps");
		
		//Return new DailyStats object
		return new DailyStats (floors, steps, distance, calories, sedentaryMins, lightActiveMins, fairlyActiveMins, veryActiveMins, 
				activeMinGoals, caloriesOutGoals, distanceGoals, floorGoals, stepGoals);
	}
}
