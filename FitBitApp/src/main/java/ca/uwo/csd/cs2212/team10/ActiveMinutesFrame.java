package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;

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
	public ActiveMinutesFrame(int lightActiveMins, int fairlyActiveMins, int veryActiveMins, int activeMinGoals, int floors, int steps, double distance,int floorGoals,int stepGoals,double distanceGoals) {
		
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +
				"<u>Active Minutes</u>" +
				"<br>Light: " + lightActiveMins + 
				"<br>Fairly: " + fairlyActiveMins +
				"<br>Very: " + veryActiveMins + 
				"<br>Goals: " + activeMinGoals + 
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		lblName.setBounds(300, 184, 110, 100);
		lblName.setOpaque(false);	
		lblName.setToolTipText("Daily Goals");
		this.setBackground(new Color(155, 155, 155)); 
		setLayout(null);
		
		
		//this.add(content);
		this.add(lblName);
		String	stepslabel;
		
		int stepsLeft= stepGoals-steps;
		if(stepsLeft<0){
				// JLabels to print the text for the testFitBitAPI
			stepslabel = "<html>" +  "<br> You are above your goal by "+ -stepsLeft+
						"<br>Steps: " + steps + " steps"+
						"<br>Steps (Goals): " + stepGoals + " steps"+
						"</html>";
		}
		else if(stepsLeft>0){
			stepslabel = "<html>" +  "<br> You are below your goal by "+ stepsLeft+
						"<br>Steps: " + steps + " steps"+
						"<br>Steps (Goals): " + stepGoals + " steps"+
						"</html>";
		}
		else{ 
			 stepslabel = "<html>" +  "<br> You are met your goal by "+ stepsLeft+
						"<br>Steps: " + steps + " steps"+
						"<br>Steps (Goals): " + stepGoals + " steps"+
						"</html>";
			
		}
		
		JLabel lblSteps = new JLabel(stepslabel);
		lblSteps.setBounds(150, 115, 140, 70);
		add(lblSteps);
		
	String	floorslabel;
		
		int floorsLeft= stepGoals-steps;
		if(floorsLeft<0){
				// JLabels to print the text for the testFitBitAPI
			floorslabel = "<html>" +  "<br> You are above your goal by "+ -floorsLeft+
						"<br>floors: " + floors + " steps"+
						"<br>floors (Goals): " + floorGoals + " floors"+
						"</html>";
		}
		else if(floorsLeft>0){
			floorslabel = "<html>" +  "<br> You are below your goal by "+ floorsLeft+
						"<br>floors: " + floors + " steps"+
						"<br>floors (Goals): " + floorGoals + " floors"+
						"</html>";
		}
		else{ 
			floorslabel = "<html>" +  "<br> You are met your goal by "+ floorsLeft+
						"<br>floors: " + floors + " steps"+
						"<br>floors (Goals): " + floorGoals + " floors"+
						"</html>";
			
		}
		
		
		
		JLabel lblNewLabel_1 = new JLabel(floorslabel);
		lblNewLabel_1.setBounds(20, 195, 135, 70);
		add(lblNewLabel_1);
		
		int trial=7;
		double activeMin = (lightActiveMins + fairlyActiveMins + veryActiveMins)/(double)activeMinGoals;
		int angleProgressActiveMin = (int)((activeMin)*360);
		
		double floorsArc = (trial)/(double)floorGoals;
		int angleProgressFloors = (int)((floorsArc)*360);
		
		double stepsArc = (steps)/(double)stepGoals;
		int angleProgressSteps = (int)((stepsArc)*360);
		
		
		ProgressBar progBar1 = new ProgressBar(0, 0,  Color.RED);
		progBar1.setArcAngle(angleProgressSteps);
		ProgressBar progBar2 = new ProgressBar(0,0, Color.BLUE);
		ProgressBar progBar3 = new ProgressBar(0,0, Color.YELLOW);
		progBar3.setArcAngle(angleProgressActiveMin);
		
		
		/*
		JLabel lblNewLabel_2 = new JLabel("<html>"+ distance + " Miles<br>"+ distanceGoals +" to go<html>");
		lblNewLabel_2.setBounds(357, 215, 92, 32);
		add(lblNewLabel_2);
		*/
		
		/*JLabel btnNewButton_2 = new JLabel("");
		btnNewButton_2.setIcon(new ImageIcon("/Users/linaradwan/Downloads/ActiveMin.png"));
		btnNewButton_2.setBounds(290, 85, 128, 108);
		add(btnNewButton_2);
	*/
		
		JLabel btnNewButton_1 = new JLabel("");
		btnNewButton_1.setIcon(new ImageIcon("ActiveMin.png"));
		btnNewButton_1.setBounds(287, 85, 128, 108);
		progBar3.setBounds(302, 89, 128, 122);
		add(btnNewButton_1);
		add(progBar3);

		/*
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("/Users/linaradwan/Downloads/ActiveMin.png"));
		btnNewButton_3.setBounds(176, 165, 121, 108);
		add(btnNewButton_3);
		*/
		/*JLabel btnNewButton_1 = new JLabel("");
		btnNewButton_1.setIcon(new ImageIcon("/Users/linaradwan/Downloads/Steps.png"));
		btnNewButton_1.setBounds(137, 0, 135, 122);
		add(btnNewButton_1);
		*/
		

		JLabel stepsPic = new JLabel("");
		stepsPic.setIcon(new ImageIcon("StepsGoals.png"));
		stepsPic.setBounds(138, 0, 135, 122);
		progBar1.setBounds(153, 13, 128, 150);
		add(stepsPic);
		this.add(progBar1);

		
		/*JLabel btnNewButton = new JLabel("");
		btnNewButton.setIcon(new ImageIcon("/Users/linaradwan/Downloads/floors.png"));
		btnNewButton.setBounds(12, 85, 121, 108);
		add(btnNewButton);*/
		progBar2.setArcAngle(angleProgressFloors);
		JLabel floorsPic = new JLabel("");
		floorsPic.setIcon(new ImageIcon("floors.png"));
		floorsPic.setBounds(12, 85, 121, 108);
		progBar2.setBounds(22, 89, 128, 122);
		add(floorsPic);
		add(progBar2);
		
		
	}
	
	
	
	private class ProgressBar extends JComponent {
		Ellipse2D.Double fill;
		Area inside;
		int x;
		int y;
		int width = 100;
		int height = 100;
		int startAngle = 0; 
		int arcAngle = 270;
		Color colour;
		
		public ProgressBar(int startX, int startY, Color colourIn) {
			//When initializing the progress bar, we will also initialize the bars position and color
			this.x = startX;
			this.y = startY;
			this.colour = colourIn;
		}
		
		public void setArcAngle(int angle) {
			this.arcAngle = angle;
		}

		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			//Graphics2D g2 = (Graphics2D) g;
			g.setColor(colour);

			//Fill the progress bar
			g.fillArc(this.x, this.y, width, height, startAngle+270, arcAngle);
			g.setColor(this.getBackground());
			g.fillArc(x+10, y+10, width-20, height-20, startAngle, 360);

		}
	}
	
	
	
}
