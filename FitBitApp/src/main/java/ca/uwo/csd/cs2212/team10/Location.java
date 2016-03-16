package ca.uwo.csd.cs2212.team10;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; 
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Location {

    private String name;
    private String coordinates;
    private double distance;
    private boolean achieved = false;
    private String imageFile;

    public Location(String name, String coordinates) {
        this.name = name; 
        this.coordinates = coordinates;
    }
    public Location(String name, String coordinates, double distance, boolean achieved) {
        this.name = name;
        this.coordinates = coordinates;
        this.distance = distance; 
        this.achieved = achieved;
    }

    public String getLocationImage() {

        this.imageFile = "src/main/resources/locationImages/" + this.coordinates + ".png";
        if(!(new File(imageFile).exists())) {
            BufferedImage image = null;
            try {
                String imageURL = "https://maps.googleapis.com/maps/api/staticmap?size=200x200&center=" + this.name.replaceAll("\\s","%20") + "&key=AIzaSyA3qYxpHJKnTbHfW1oRcCSpycKqKUvwvV0";
                URL url = new URL(imageURL);
                image = ImageIO.read(url);
                ImageIO.write(image,"png",new File(imageFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imageFile;
    }

    public String getName() {
        return this.name;
    }
    public String getCoordinates() {
        return this.coordinates;
    }
    public double getDistance() {
        return this.distance;
    }
    public boolean getAchieved() {
        return this.achieved;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
}
