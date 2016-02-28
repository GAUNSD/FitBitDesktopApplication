import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.json.JSONException;
/**
 * A class that creates the main UI windows 
 * It calls out the MainTabWindow that has all the panels 
 * CS 2212 FitBit
 * @author Team 10
 *
 */
public class MainWindow extends JFrame{
	
	
	public MainWindow() throws JSONException, TokensException {
		this.initUI();
	}

	private void initUI() throws JSONException, TokensException {
		// Create and set up the window with its initial attributes.
		this.setTitle("Fit Bit");
		this.setSize(1230, 685); // The screen size should be 16x9; We use a scale factor of 75
	    this.setLocationRelativeTo(null);
	    this.setBackground(new Color(55, 55, 55));
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	    
	    // Add/Create the Menu Bar using the createMenuBar Method
	  	this.setJMenuBar(this.createMenubar());
	    
	    // Create the Main Tab Window. This JPanel will be used to navigate through the window
 		MainTabWindow mainTabWindow = new MainTabWindow();
		getContentPane().add(mainTabWindow, BorderLayout.CENTER);
			}

	private JMenuBar createMenubar() {
		// Create the Top Menu Bar and set its attributes
		MyMenuBar topMenubar = new MyMenuBar();
		topMenubar.setBackground(new Color(87, 87, 87));
		topMenubar.setPreferredSize(new Dimension(1200, 70)); // height
		
		// Add all the created elements to their respective containers
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img0=new ImageIcon("src/main/resources/fitbitlogo.png");
		lblNewLabel.setIcon(img0);
		topMenubar.add(lblNewLabel);
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		
		
		return topMenubar;	
	}
}