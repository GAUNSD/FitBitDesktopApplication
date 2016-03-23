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
		this.setLayout(null);
		String stringLabel;
int caloriesLeft= caloriesOutGoals-calories;
if(caloriesLeft<0){
		// JLabels to print the text for the testFitBitAPI
		 stringLabel = "<html>" +  "<br> You are above your goal by "+ -caloriesLeft+
				"<br>Calories: " + calories + " cal"+
				"<br>Calories (Goals): " + caloriesOutGoals + " cal"+
				"</html>";
}
else if(caloriesLeft>0){
	 stringLabel = "<html>" +  "<br> You are below your goal by "+ caloriesLeft+
			"<br> Calories: " + calories + 
			"<br> Calories (Goals): " + caloriesOutGoals + 
			"</html>";
	
}
else{ 
	stringLabel = "<html>" +  "<br> You have met your goal"+
		"<br>Calories: " + calories+ "cal"+ 
		"<br>Calories (Goals): " + caloriesOutGoals + "cal"+
		"</html>";
	
}
		JLabel lblName = new JLabel(stringLabel);
		lblName.setBounds(4, 80, 198, 135);

		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/caloriesBurned.png"));
		lblNewLabel.setBounds(33,0, 198, 132);
		
		
		this.setBackground(new Color(155, 155, 155));
		this.add(lblNewLabel);
		
		//this.add(content);
		this.add(lblName);
	}
}
