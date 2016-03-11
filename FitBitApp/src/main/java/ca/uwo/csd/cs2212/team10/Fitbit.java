package ca.uwo.csd.cs2212.team10;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class will be used to get information from Fitbit services
 * as well as calling for new tokens and saving data
 * Consists of: Heart Statistics, Best and Lifetime Statistics, Daily Statistics and Goals
 * @author Pearson and Patrick
 * This class will be used to get information from Fitbit services
 * as well as calling for new tokens and saving data
 * Consists of: Heart Statistics, Best and Lifetime Statistics, Daily Statistics and Goals
 */
public interface Fitbit
{	

	
	/**
	 * Best Statistics Call
     * @return BestLifeStats object containing all best life statistics data
     * @throws JSONException method calls a JSON file which can throw this error
     * @throws TokensException method uses tokens which can throw this error
	 */
	public BestLifeStats getBestLifeActivity() throws JSONException, TokensException;


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
	public HeartStats getHeartActivity(String year, String month, String day) throws JSONException, TokensException;

	/**
     * Daily Statistics Call
     * @param year String that contains the year of request
     * @param month String that contains the month of request
     * @param day String that contains the day of request
     * @return DailyStats object containing all the daily statistics data
     * @throws JSONException Method requests a JSON file that can throw this error
     * @throws TokensException Method uses tokens to interface with API which can throw this error
	 */
	public DailyStats getDailyActivity(String year, String month, String day) throws JSONException, TokensException;

}
