package ca.uwo.csd.cs2212.team10;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Font;


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
	public HeartRateZoneFrame(int outOfRange,int fatBurn, int cardio, int peak, int restHeartRate) {
		setLayout(null);

		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +  
				"<br>Fat Burn: " + fatBurn + 
				"<br>Cardio: " + cardio +
				"<br>Peak: " + peak + 
				"<br>OutOfRange: " + outOfRange + 
				"</html>";
		//JFreeChart PieChart;
		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("Fat Burn", fatBurn);
		dataSet.setValue("Cardio", cardio);
		dataSet.setValue("Peak", peak);
		dataSet.setValue("OutOfRange", outOfRange);
		JFreeChart PieChart= ChartFactory.createPieChart("", dataSet,true, true, false);
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		ChartPanel CP= new ChartPanel(PieChart);
		CP.setBounds(50, 41, 364, 200);
		lblName.setBounds(100, 160, 266, 213);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(155, 155, 155));
		//this.add(content);
		this.add(lblName);
		this.add(CP);
		
		JLabel lblRestingHeartRate = new JLabel("Resting Heart Rate");
		lblRestingHeartRate.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblRestingHeartRate.setBounds(15, 2, 192, 33);
		add(lblRestingHeartRate);
		
		JLabel label = new JLabel(" "+restHeartRate+"bpm");
		label.setFont(new Font("SimSun", Font.PLAIN, 16));
		label.setBounds(400, 2, 111, 33);
		add(label);
		
		
	}
}
