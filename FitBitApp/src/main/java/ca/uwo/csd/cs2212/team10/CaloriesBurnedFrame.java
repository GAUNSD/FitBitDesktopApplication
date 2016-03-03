package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

/**
 * This class represents the information for the Dashboard element 'Calories Burned'
 * This will house all the data (as parameters in the constructor) and the graphical elements.
 * As of Stage 2, only data is being supplied
 * 
 * @author Gustavo Murcia
 */
public class CaloriesBurnedFrame extends JPanel {

	/**
	 * The constructor for the Calories Burned Frame. 
	 * The parameters represent information coming from the API
	 * 
	 * @param calories integer containing calorie usage count
	 * @param caloriesOutGoals integer containing calorie usage goal
	 */
	public CaloriesBurnedFrame(int calories, int caloriesOutGoals) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" + 
				"<br>Calories: " + calories + 
				"<br>Calories (Goals): " + caloriesOutGoals + 
				"</html>";
		
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
