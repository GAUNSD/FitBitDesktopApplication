package ca.uwo.csd.cs2212.team10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import jabva.util.Iterator;

import javax.swing.ImageIcon;
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
public class Maps {

    private JSONObject locationDistances; 

    public static void calculateDistances() throws IOException, JSONException {
        
        // Read from locations.json
        JSONParser parse = new JSONParser();
        
        Object obj = parser.parse(new FileReader("src/main/resources/locations.json"));
        JSONObject object = (JSONObject) obj; 

        JSONArray locations = object.getJSONArray("locations"); 

        for (int i = 0; i < locations.length; i++) {
        }
    }

    pubic static void getCurrentLocation() 












    public static void main(String[] args) {
        JFrame test = new JFrame("Google Maps");

        try {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=London,Ontario&zoom=1&size=1920x1080&maptype=roadmap&key=AIzaSyA3qYxpHJKnTbHfW1oRcCSpycKqKUvwvV0&format=png";
            String destinationFile = "src/main/resources/maptest.png";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();

            test.add(new JLabel(new ImageIcon((new ImageIcon("src/main/resources/maptest.png")).getImage().getScaledInstance(1920,1080,java.awt.Image.SCALE_SMOOTH))));  
            test.setVisible(true);
            test.pack();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
