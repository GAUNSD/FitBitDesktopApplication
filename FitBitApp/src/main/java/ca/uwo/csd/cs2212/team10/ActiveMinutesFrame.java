package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

/**
 * This class represents the information for the Dashboard element 'Active Minutes'
 * This will house all the data (as parameters in the constructor) and the graphical elements.
 * As of Stage 2, only data is being supplied
 * 
 * @author Gustavo Murcia
 */
public class ActiveMinutesFrame extends JPanel {
	//TMP
	private final static int MAX_PROGRESS_AMOUNT = 100;
	private static final int DELAY = 50;
	private Timer timer;
	private int prgValue = 0;
	//
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
		super(new GridLayout(1, 5));

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

		//Calculate the progress of the Active Minute Goals	
		double d = (lightActiveMins + fairlyActiveMins + veryActiveMins)/(double)activeMinGoals;
		int angleProgress = (int)((d)*360);

		/////This might not be the best way to do it

		ProgressBar progBar1 = new ProgressBar(0, 0,  Color.RED);
		ProgressBar progBar2 = new ProgressBar(0,0, Color.BLUE);
		ProgressBar progBar3 = new ProgressBar(0,200, Color.YELLOW);
		ProgressBar progBar4 = new ProgressBar(0,200, Color.ORANGE);
		ProgressBar progBar5 = new ProgressBar(0,200, Color.GREEN);
		
		
		progBar1.setArcAngle(180);
		progBar2.setArcAngle(180);
		progBar3.setArcAngle(180);
		progBar4.setArcAngle(180);
		progBar5.setArcAngle(180);
		//this.add(content);
		this.add(progBar1);
		this.add(progBar2);
		this.add(progBar3);
		this.add(progBar4);
		this.add(progBar5);
		//this.add(lblName);
	}

	/*
	 * Private class to draw the progress bar for the active minutes
	 */
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
	public static void main(String[] args) {
		// Test Data 
		int lightActiveMins = 123;
		int fairlyActiveMins = 456;
		int veryActiveMins = 789;
		int activeMinGoals = 1500;

		// Create the Frames needed 
		ActiveMinutesFrame testActiveMin = new ActiveMinutesFrame(lightActiveMins, fairlyActiveMins,veryActiveMins,activeMinGoals);
		JInternalFrame testFrame = new JInternalFrame("Test");
		testFrame.setLocation(100, 100 );
		//testFrame.setSize( 200, 200 );
		testFrame.setVisible( true );
		testFrame.setResizable( false );
		testFrame.setIconifiable( false );
		JDesktopPane testPanel = new JDesktopPane();
		JFrame testOFrame = new JFrame();
		testOFrame.setSize(1000, 800);

		// add the elements for the frame

		testFrame.setSize(800, 800);
		testFrame.getContentPane().add(testActiveMin, BorderLayout.CENTER);
		
		
		testPanel.add(testFrame);

		testOFrame.add(testPanel);
		testOFrame.setVisible(true);
	}
}



