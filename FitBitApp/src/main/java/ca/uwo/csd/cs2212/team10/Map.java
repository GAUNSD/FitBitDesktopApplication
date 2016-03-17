package ca.uwo.csd.cs2212.team10;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.StringBuffer; 
import java.net.URL;
import java.util.Iterator;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;

/**
 * This class implements the backend of the map functionality. 
 *
 * @author Conor
 */
public class Map {

    private Location[] locations; 
    private double distance;
    private Location currentLocation;
    private boolean locationSet = false; 
    private Fitbit fitbit;

    public Map(Fitbit fitbit) {
        this.fitbit = fitbit;
        this.distance = getLifeDistance();

        if(new File("src/main/resources/locations.json").exists()) {
            this.locationSet = true;
            // Parse into array of locations and current location
        }
        else {
            // read from locationBank.json into array of locations
        }
    }


    public void calculateDistances() throws IOException, JSONException {

        // Read from locations.json
        /*
           JSONParser parser = new JSONParser();

           Object obj = parser.parse(new FileReader("src/main/resources/locationBank.json"));
           JSONObject object = (JSONObject) obj; 

           JSONArray locations = object.getJSONArray("locations"); 

           for (int i = 0; i < locations.length(); i++) {
           }*/
    }

    private double getLifeDistance() {
        try {
            return fitbit.getBestLifeActivity().getLifeDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private String readURL(String requestURL) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(requestURL);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    
    public Location getNewLocation(String locationName) {
        // Call google API to get coordinates, and city name
        // return location object
        String requestURL = "https://maps.googleapis.com/maps/api/geocode/json?address=" + locationName.replaceAll("\\s","%20") + "&key=AIzaSyA3qYxpHJKnTbHfW1oRcCSpycKqKUvwvV0";
        try {
            JSONObject object = new JSONObject(readURL(requestURL));
            
            JSONObject results = object.getJSONObject("results");
            String formattedAddress = results.getString("formatted_address");
            
            JSONObject geometry = results.getJSONObject("geometry");
            JSONObject locationCoordinates = geometry.getJSONObject("location");
            String coords = locationCoordinates.getString("lat") + locationCoordinates.getString("lng");

        } catch(JSONException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new Location(formattedAddress,coords); 
    }

public void setCurrentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
    // Calculate distances, write to locations.json, write image of city src/main/resources/locationImages/
}


public boolean getLocationSet() {
    return this.locationSet; 
}
public Location getCurrentLocation() {
    return this.currentLocation;
}

}
