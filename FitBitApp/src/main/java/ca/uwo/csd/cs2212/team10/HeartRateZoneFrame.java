package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

/**
 * This class represents the information for the Dashboard element 'Heart Rate Zone'
 * This will house all the data (as parameters in the constructor) and the graphical elements.
 * As of Stage 2, only data is being supplied
 * 
 * @author Gustavo Murcia
 */
public class HeartRateZoneFrame extends JPanel {

	/**
	 * The constructor for the Heart Rate Zone Frame. 
	 * The parameters represent information coming from the API
	 * 
	 * @param fatBurn integer that contains fat burn heart rate
	 * @param cardio integer that contains cardio heart rate
	 * @param peak integer that contains peak heart raate
	 * @param restHeartRate integer that contains the resting heart rate
	 */
	public HeartRateZoneFrame(int fatBurn, int cardio, int peak, int restHeartRate) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +  
				"<br>Fat Burn: " + fatBurn + 
				"<br>Cardio: " + cardio +
				"<br>Peak: " + peak + 
				"<br>Resting HeartRate: " + restHeartRate + 
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
