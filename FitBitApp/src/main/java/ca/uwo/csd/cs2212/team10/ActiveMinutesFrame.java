package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

/**
 * This class represents the information for the Dashboard element 'Active Minutes'
 * This will house all the data (as parameters in the constructor) and the graphical elements.
 * As of Stage 2, only data is being supplied
 * 
 * @author Gustavo Murcia
 */
public class ActiveMinutesFrame extends JPanel {

	/**
	 * The constructor for Active Minutes Frame. 
	 * The parameters represent information coming from the API
	 * 
	 * @param lightActiveMins integer that contains light active minutes
	 * @param fairlyActiveMins integer that contains fairly active minutes
	 * @param veryActiveMins integer that contains very active minutes
	 * @param activeMinGoals integer that contains active minute goals
	 */
	public ActiveMinutesFrame(int lightActiveMins, int fairlyActiveMins, int veryActiveMins, int activeMinGoals) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +
				"<u>Active Minutes</u>" +
				"<br>Light: " + lightActiveMins + 
				"<br>Fairly: " + fairlyActiveMins +
				"<br>Very: " + veryActiveMins + 
				"<br><br>Goals: " + activeMinGoals + 
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
