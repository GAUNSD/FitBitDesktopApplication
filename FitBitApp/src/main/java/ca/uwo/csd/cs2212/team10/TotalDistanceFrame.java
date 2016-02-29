package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

public class TotalDistanceFrame extends JPanel {


	public TotalDistanceFrame(int floors, int steps, double distance) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));

		// Unsure if this is needed 
		/*
		JPanel content = new JPanel();
		content.setBackground(new Color (55,55,55));
		*/
		
		//TMP - FOR API TEST
		
		// Info from the DailyStats Api class from the APITeam


		// JLabels to print the text for the testFitBitAPI
		JLabel lblName = new JLabel("<html><i>Floors:</i> " + floors + 
				".<br><i>Steps:</i> " + steps + 
				"<br><i>Distance:</i> " + distance + "</html>",
				JLabel.CENTER);
		lblName.setOpaque(true);	
		lblName.setToolTipText("A label containing both image and text");
		
		
		//this.add(content);
		this.add(lblName);
	}

}