package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

/**
 * This class represents the information for the Dashboard element 'Sedentary Minutes Frame'
 * This will house all the data (as parameters in the constructor) and the graphical elements.
 * As of Stage 2, only data is being supplied
 * 
 * @author Gustavo Murcia
 */
public class SedentaryMinutesFrame extends JPanel {

	/**
	 * The constructor for the Sedentary Minutes Frame. 
	 * The parameters represent information coming from the API
	 * 
	 * @param sedentaryMins integer that contains sedentary minutes
	 */
	public SedentaryMinutesFrame(int sedentaryMins) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +
				"<br>Sedentary Minutes: " + sedentaryMins +  
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
