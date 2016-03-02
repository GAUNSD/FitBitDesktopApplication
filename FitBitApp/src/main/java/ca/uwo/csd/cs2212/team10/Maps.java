package ca.uwo.csd.cs2212.team10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Maps {
    public static void main(String[] args) {
        JFrame test = new JFrame("Google Maps");

        try {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=London,Ontario&zoom=13&size=1200x600&maptype=roadmap&key=AIzaSyA3qYxpHJKnTbHfW1oRcCSpycKqKUvwvV0&format=png";
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

            test.add(new JLabel(new ImageIcon((new ImageIcon("src/main/resources/maptest.png")).getImage().getScaledInstance(1200, 600,java.awt.Image.SCALE_SMOOTH))));  
            test.setVisible(true);
            test.pack();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
