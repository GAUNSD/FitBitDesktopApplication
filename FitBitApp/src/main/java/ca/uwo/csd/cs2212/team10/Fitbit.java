
package ca.uwo.csd.cs2212.team10;

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

public class Fitbit
{
	private static String CALL_BACK_URI = "http://localhost:8080";
	private static int CALL_BACK_PORT = 8080;
	
	/**
	 * THIS MAIN CAN BE MOVED ELSEWHERE, JUST HERE FOR TESTING
	 */
	public static void main (String [] args){
		getDailySteps ("2016","01", "08");
	}
	
	
	public static void getDailyFloors (String year, String month, String day) {
		
		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/floors/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
		
		getAPI (requestUrl);
	}


	public static void getDailySteps (String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/steps/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	
	}

	public static void getDailyCalories (String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/calories/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}

	public static void getDailyDistance (String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/distance/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}


	public static void getDailySedentaryMins (String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesSedentary/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}

		/**
		 * WE WILL NEED TO ADD ALL THREE ACTVITY LEVELS TO GET TOTAL ACTIVITY PER DAY!!
		 */
	public static void getDailyLightActivity(String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesLightlyActive/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}


	public static void getDailyFairlyActivity(String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesFairlyActive/date/";
	
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}	

	public static void getDailyVigorousActivity(String year, String month, String day) {

		String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/activities/tracker/minutesVeryActive/date/";
		
		String requestUrl = requestUrlPrefix + year +"-"+ month +"-"+ day +"/"+ "1d" + ".json";
	
		getAPI (requestUrl);
	}
	
	/** THIS API CALL GETS THE BEST DAYS AND LIFETIME STATS..NEED TO PARSE THROUGH TO GET DISTANCE,FLOORS, STEPS ETC. **/
	
	public static void getBestAndLifetime () {
		
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
	public static void getAPI (String requestUrl){
		
		//read credentials from a file
		BufferedReader bufferedReader = null;
		//to reference a line
		String line = null;

		//service credentials for Fitbit
		String apiKey = null;
		String apiSecret = null;
		String clientID = null;

		//holder for elements that we make access tokens (authenticated session)
		String accessTokenItself = null;
		String tokenType = null;
		String refreshToken = null;
		String rawResponse = null;
		Long expiresIn = null;

		//only scope to access currently
		String scope = "activity%20heartrate";
		try
		{
			//file with service credentials
			FileReader fileReader = new FileReader("src/main/resources/Team10Credentials.txt");
			bufferedReader = new BufferedReader(fileReader);
			clientID = bufferedReader.readLine();
			apiKey = bufferedReader.readLine();
			apiSecret = bufferedReader.readLine();
			bufferedReader.close();

			fileReader = new FileReader("src/main/resources/Team10Tokens.txt");
			bufferedReader = new BufferedReader(fileReader);
			accessTokenItself = bufferedReader.readLine();
			tokenType = bufferedReader.readLine();
			refreshToken = bufferedReader.readLine();
			expiresIn = Long.parseLong(bufferedReader.readLine());
			rawResponse = bufferedReader.readLine();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to open file\n" + e.getMessage());
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println("Error reading/write file\n" + e.getMessage());
			System.exit(1);
		}
		finally
		{
			try
			{
				//always close files
				if(bufferedReader != null)
					bufferedReader.close();
			}
			catch (Exception e)
			{
				System.out.println("Error closing file\n" + e.getMessage());
			}
		}

		//Create the Fitbit service - you will ask this to ask for access/refresh pairs
		//and to add authorization infomration to the requests to the API
		FitbitOAuth20ServiceImpl service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
			.apiKey(clientID)
			.apiSecret(apiSecret)
			.callback("http://localhost:8080")
			.scope(scope)
			.grantType("authorization_code")
			.build(FitbitApi20.instance());

		//The access token contains everything you will need to authenticate your request
		//It can expire - at which you will use the refresh token to refresh it
		//See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
		OAuth2AccessToken accessToken = new OAuth2AccessToken(accessTokenItself, tokenType, refreshToken, expiresIn, rawResponse);

		System.out.println("Now we're going to access a protected resource...");
		System.out.println();

		//String requestUrl = exampleMethod.getDailyDistance("2016","01","08");
		
		//This generates an HTTP request from the URL
		OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);

		//This adds the information required by Fitbit to add the authorization information to the HTTP request
		//YOU MUST DO THIS BEFORE THE REQUEST WILL WORK
		//See: https://dev.fitbit.com/docs/oauth2/#making-requests
		service.signRequest(accessToken, request);
		//If you are curious, since it has a header, body...
		System.out.println(request.toString());
		System.out.println(request.getHeaders());
		System.out.println(request.getBodyContents());
		
		
		//To send the requestURL
		Response response = request.send();

		//The HTTP response from gitbit will be in HTTP format. meaning that is has a numeric code indicating
		//whether it was successfull (200) or not (400's or 500's)
		System.out.println("\n HTTP response code: " + response.getCode());
		int statusCode = response.getCode();

		switch(statusCode)
		{
			case 200:
				System.out.println("Success!\n HTTP response body:\n" + response.getBody());
				break;
			case 400:
				System.out.println("Bad Request\n HTTP resonse body:\n" + response.getBody());
				break;
			case 401:
				System.out.println("Likely Expired Token\n HTTP resonse body:\n" + response.getBody());
				System.out.println("Try to refresh");

				//This uses the refresh token to get a completely new accessToken object
				//See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
				//This accessToken is now the current one, and the old ones will not work again
				//You should save the contents of accessToken
				accessToken = service.refreshOAuth2AccessToken(accessToken);

				//Now we can try to access the service again
				//Make sure you create a new OAuthRequest obejct each time!

				request = new OAuthRequest(Verb.GET, requestUrl, service);
				service.signRequest(accessToken, request);
				response = request.send();

				//Check again to see what response you got
				System.out.println("HTTP response code: " + response.getCode());
				System.out.println("HTTP response body: " + response.getBody());
				break;
			case 429:
				System.out.println("Rate Limit Exceeded\n HTTP response body\n" + response.getBody());
				break;
			default:
				System.out.println("HTTP response code: " + response.getCode());
				System.out.println("HTTP response body: " + response.getBody());
		}

		BufferedWriter bufferedWriter = null;
		//Save the current accessToken information for next time
		//If you do not save the currently active token info you will not be able to refresh
		//contact Beth if this happens and she can reissue you a fresh set

		try
		{
			FileWriter fileWriter;
			fileWriter = new FileWriter("src/main/resources/Team10Tokens.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(accessToken.getToken());
			bufferedWriter.newLine();
			bufferedWriter.write(accessToken.getTokenType());
			bufferedWriter.newLine();
			bufferedWriter.write(accessToken.getRefreshToken());
			bufferedWriter.newLine();
			bufferedWriter.write(accessToken.getExpiresIn().toString());
			bufferedWriter.newLine();
			bufferedWriter.write(accessToken.getRawResponse());
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to open file\n" + e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("Error reading/write file\n" + e.getMessage());
		}
		finally
		{
			try
			{
				if (bufferedWriter!=null)
					bufferedWriter.close();
			}
			catch (Exception e)
			{
				System.out.println("Error closing file\n" + e.getMessage());
			}
		}
	}
}
