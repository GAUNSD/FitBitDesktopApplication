import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class MainTabWindow extends JPanel {

	public MainTabWindow() {

		super(new GridLayout(1, 1));

/*
				HeartStats low=Fitbit.getHeartActivity("2016", "01", "29");
				System.out.println(low.getCardio());
				BestLifeStats mid=Fitbit.getBestLifeActivity();
				DailyStats high=Fitbit.getDailyActivity("2016", "01", "29");
				
		mid.get
		
		*/
		
		
		


		//create a tabbed pane that will hold the contents
		JTabbedPane tabbedPane = new JTabbedPane();


		/**
		 * Empty Dashboard
		 */
		JComponent panel1 = makeTextPanel("Custom Dashboard");								
		//add a panel that we the elements are gonna be added on 
		JPanel panelback1 = new JPanel();
		panelback1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelback1.setBackground(new Color(40, 40, 40));
		panelback1.setForeground(new Color(40, 40, 40));
		panelback1.setBounds(0, 0, 1128, 644);
		panel1.add(panelback1, BorderLayout.WEST);
		panelback1.setLayout(null);
		
		JPanel dailyActPanel = new JPanel();
		dailyActPanel.setBackground(new Color(155,155,155));
		dailyActPanel.setVisible(false);
		dailyActPanel.setBounds(6, 12, 244, 546);
		panelback1.add(dailyActPanel);
		dailyActPanel.setLayout(null);
		
		JLabel steps = new JLabel("");
		steps.setBounds(47, 5, 178, 159);
		steps.setIcon(new ImageIcon("/Users/linaradwan/Downloads/rsz_screen_shot_2016-02-27_at_113055_pm.png"));
		dailyActPanel.add(steps);
		
		JLabel floor = new JLabel("");
		floor.setIcon(new ImageIcon("/Users/linaradwan/Desktop/Screen Shot 2016-02-27 at 11.30.47 PM.png"));
		floor.setBounds(0, 191, 127, 111);
		dailyActPanel.add(floor);
		
		JLabel distance = new JLabel("");
		distance.setIcon(new ImageIcon("/Users/linaradwan/Desktop/Screen Shot 2016-02-27 at 11.30.42 PM.png"));
		distance.setBounds(114, 191, 148, 121);
		dailyActPanel.add(distance);
		
		JLabel active = new JLabel("");
		active.setIcon(new ImageIcon("/Users/linaradwan/Desktop/Screen Shot 2016-02-27 at 11.31.03 PM.png"));
		active.setBounds(-7, 380, 127, 111);
		dailyActPanel.add(active);
		
		JLabel calories = new JLabel("");
		calories.setIcon(new ImageIcon("/Users/linaradwan/Desktop/Screen Shot 2016-02-27 at 11.30.35 PM.png"));
		calories.setBounds(117, 380, 127, 111);
		dailyActPanel.add(calories);
		
		JPanel timeSeriesPanel = new JPanel();

		timeSeriesPanel.setBounds(262, 12, 480, 272);
		timeSeriesPanel.setBackground(new Color(155,155,155));
		timeSeriesPanel.setVisible(false);
		panelback1.add(timeSeriesPanel);
		
		JPanel heartRatePanel = new JPanel();
		heartRatePanel.setBounds(262, 296, 480, 262);
		heartRatePanel.setBackground(new Color(155,155,155));
		heartRatePanel.setVisible(false);
		panelback1.add(heartRatePanel);
		
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(754, 12, 404, 314);
		mapPanel.setBackground(new Color(155,155,155));
		mapPanel.setVisible(false);
		panelback1.add(mapPanel);
		
		JPanel sedPanel = new JPanel();
		sedPanel.setBounds(749, 338, 186, 220);
		sedPanel.setBackground(new Color(155,155,155));
		sedPanel.setVisible(false);
		panelback1.add(sedPanel);
		sedPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, -10, 191, 195);
		lblNewLabel.setIcon(new ImageIcon("/Users/linaradwan/Downloads/rsz_1screen_shot_2016-02-27_at_73149_pm.png"));
		sedPanel.add(lblNewLabel);
		
		JPanel caloriesPanel = new JPanel();
		caloriesPanel.setBounds(947, 338, 207, 220);
		caloriesPanel.setBackground(new Color(155,155,155));
		caloriesPanel.setVisible(false);
		panelback1.add(caloriesPanel);
		caloriesPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/linaradwan/Downloads/rsz_1screen_shot_2016-02-27_at_73102_pm.png"));
		lblNewLabel_1.setBounds(13, -12, 155, 195);
		caloriesPanel.add(lblNewLabel_1);
		// add a button to custom dashbboard
		JButton btnadd = new JButton("+ Add elements to get started"); 
		btnadd.setBounds(478, 290, 257, 29);
		panelback1.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		
					
				btnadd.setForeground(new Color(255, 255, 255));
				btnadd.setBackground(new Color(40, 40, 40));
				btnadd.setBorderPainted(false);
		//add the the panel to the tabbedpane
		ImageIcon icon1 = new ImageIcon("home_icon.png");
		tabbedPane.addTab("Dashboard",icon1 , panel1, "tmp1");	
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setBackgroundAt(0, Color.WHITE);


		/**
		 * Dashboard Menu
		 */
		JComponent panel2 = makeTextPanel("Dashboard Menu");
		//create a label named dashboard menu and add it to the panel
		
		JLabel lblmenu = new JLabel("Dashboard Menu");
		lblmenu.setForeground(SystemColor.inactiveCaption);
		lblmenu.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblmenu.setBounds(44, 6, 543, 72);
		panel2.add(lblmenu);
		//add a scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(40, 40, 40));
		scrollPane.setForeground(new Color(40, 40, 40));
		scrollPane.setBounds(18, 77, 1110, 567);

		panel2.add(scrollPane);
		//add a panel on top of the scroll pane to add the elements easier
		JPanel panelscroll = new JPanel();
		panelscroll.setBounds(79, 100, 945, 300);
		panelscroll.setBackground(new Color(40, 40, 40));
		panelscroll.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		scrollPane.setViewportView(panelscroll);
		
		JLabel mapDescript = new JLabel("");
		mapDescript.setText("<html>The Map Visualizer records <BR>your total distance walked <BR>between two places and shows <BR>how far you've gone in map.</html>");
		mapDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		mapDescript.setForeground(Color.LIGHT_GRAY);
		mapDescript.setBounds(30, 120, 328, 93);
		panelscroll.add(mapDescript);
		//add a check box for map
		JCheckBox chckbxMap_1 = new JCheckBox("Map"); 
		chckbxMap_1.setBounds(60, 220, 128, 23);
		chckbxMap_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(chckbxMap_1.isSelected()==false);
			mapPanel.setVisible(chckbxMap_1.isSelected());

			}
		});
		panelscroll.setLayout(null);
		chckbxMap_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxMap_1.setForeground(Color.WHITE);
		
		panelscroll.add(chckbxMap_1);

		JLabel tsDescript = new JLabel("");
		tsDescript.setText("<html>The Time Series tells you <BR>the information for all your <BR>accumulated progress,data like <BR>total steps,floors climbed.</html>");
		tsDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		tsDescript.setForeground(Color.LIGHT_GRAY);
		tsDescript.setBounds(430, 120, 728, 93);
		panelscroll.add(tsDescript);
		//add a check box for time series
		JCheckBox chckbxTimeSeries = new JCheckBox("Time Series");
		chckbxTimeSeries.setBounds(460, 220, 128, 23);
		chckbxTimeSeries.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxTimeSeries.setForeground(Color.WHITE);
		chckbxTimeSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(chckbxTimeSeries.isSelected()==false);
			timeSeriesPanel.setVisible(chckbxTimeSeries.isSelected());

			}
		});
		panelscroll.add(chckbxTimeSeries);

		JLabel hrDescript = new JLabel("");
		hrDescript.setText("<html>The Heart Rate reveals <BR>you the daily heart zone <BR>information and resting <BR>heart rate.</html>");
		hrDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		hrDescript.setForeground(Color.LIGHT_GRAY);
		hrDescript.setBounds(850, 120, 728, 93);
		panelscroll.add(hrDescript);
		//add a check box for heart rate
		JCheckBox chckbxHeartRate = new JCheckBox("Heart Rate");
		chckbxHeartRate.setBounds(900, 220, 128, 23);
		chckbxHeartRate.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxHeartRate.setForeground(Color.WHITE);
		chckbxHeartRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(chckbxHeartRate.isSelected()==false);
			heartRatePanel.setVisible(chckbxHeartRate.isSelected());

			}
		});
		panelscroll.add(chckbxHeartRate);
		
		JLabel cbDescript = new JLabel("");
		cbDescript.setText("<html>The Calories Burned shows <BR>you how many calories <BR>you consumed</html>");
		cbDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		cbDescript.setForeground(Color.LIGHT_GRAY);
		cbDescript.setBounds(30, 360, 728, 93);
		panelscroll.add(cbDescript);
		
		JCheckBox caloriesBurned = new JCheckBox("Calories Burned");
		caloriesBurned.setBounds(60, 470, 157, 23);
		caloriesBurned.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		caloriesBurned.setForeground(Color.WHITE);
		caloriesBurned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(caloriesBurned.isSelected()==false);
			caloriesPanel.setVisible(caloriesBurned.isSelected());

			}
		});
		panelscroll.add(caloriesBurned);
		
		JLabel smDescript = new JLabel("");
		smDescript.setText("<html>The Sedntary Min tells <BR>you the time that are <BR>not in active state.</html>");
		smDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		smDescript.setForeground(Color.LIGHT_GRAY);
		smDescript.setBounds(430, 360, 728, 93);
		panelscroll.add(smDescript);
		
		JCheckBox sedMin = new JCheckBox("Sedntary Min");
		sedMin.setBounds(460, 470, 168, 23);
		sedMin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		sedMin.setForeground(Color.WHITE);
		sedMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(sedMin.isSelected()==false);
			sedPanel.setVisible(sedMin.isSelected());

			}
		});
		panelscroll.add(sedMin);
		
		JLabel daDescript = new JLabel("");
		daDescript.setText("<html>The Daily Activity  <BR>recordsyour daily item<BR> and progress you <BR>worked with FitBit.</html>");
		daDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		daDescript.setForeground(Color.LIGHT_GRAY);
		daDescript.setBounds(860, 360, 728, 93);
		panelscroll.add(daDescript);
		
		JCheckBox dailyAct = new JCheckBox("Daily Activity");
		dailyAct.setBounds(900, 470, 157, 23);
		dailyAct.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		dailyAct.setForeground(Color.WHITE);
		dailyAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnadd.setVisible(chckbxHeartRate.isSelected()==false);
			dailyActPanel.setVisible(dailyAct.isSelected());

			}
		});
		panelscroll.add(dailyAct);
		
		
		//add the panel to the tabbed pane
		ImageIcon icon2 = new ImageIcon("options_icon.png");
		tabbedPane.addTab("Menu", icon2, panel2, "tmp2");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		tabbedPane.setBackgroundAt(1, Color.WHITE);


		/**
		 * Stats page
		 */
		//create a panel and add it to the tabbed pane
		ImageIcon icon3 = new ImageIcon("stats_icon.png");
		JComponent panel3 = makeTextPanel("Stats");
		tabbedPane.addTab("Stats", icon3, panel3, "tmp3");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panel3.setPreferredSize(new Dimension(410, 50));

		//panel of the life time button
		JPanel panelLifeTime = new JPanel();
		panelLifeTime.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelLifeTime.setBackground(new Color(40, 40, 40));
		panelLifeTime.setForeground(new Color(40, 40, 40));
		panelLifeTime.setBounds(150, 6, 1000, 639);
		panel3.add(panelLifeTime, BorderLayout.CENTER);
		panelLifeTime.setLayout(null);
		JLabel lblLifetime = new JLabel("Lifetime Totals");
		lblLifetime.setForeground(SystemColor.inactiveCaption);
		lblLifetime.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblLifetime.setBounds(44, 6, 382, 72);
		panelLifeTime.add(lblLifetime);

		//panel of the best days button
		JPanel panelBestDays = new JPanel();
		panelBestDays.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelBestDays.setBackground(new Color(40, 40, 40));
		panelBestDays.setForeground(new Color(40, 40, 40));
		panelBestDays.setBounds(150, 6, 1000, 639);
		panel3.add(panelBestDays, BorderLayout.CENTER);
		panelBestDays.setLayout(null);
		
		//TRIAL
	
		JLabel lblBestDays= new JLabel("Best Days");
		lblBestDays.setForeground(SystemColor.inactiveCaption);
		lblBestDays.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblBestDays.setBounds(44, 6, 382, 72);
		panelBestDays.add(lblBestDays);

		//panel of the accolades button
		JPanel panelAccolades = new JPanel();
		panelAccolades.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelAccolades.setBackground(new Color(40, 40, 40));
		panelAccolades.setForeground(new Color(40, 40, 40));
		panelAccolades.setBounds(150, 6, 1000, 639);
		panel3.add(panelAccolades, BorderLayout.CENTER);
		panelAccolades.setLayout(null);
		JLabel lblAccolades= new JLabel("Accolades");
		lblAccolades.setForeground(SystemColor.inactiveCaption);
		lblAccolades.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblAccolades.setBounds(44, 6, 382, 72);
		panelAccolades.add(lblAccolades);

		//panel where the buttons are added 
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setForeground(new Color(40, 40, 40));
		panel_1.setBounds(6, 6, 118, 640);
		panel3.add(panel_1, BorderLayout.CENTER);
		panel3.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//add button lifetime toals 
		JToggleButton tglbtnNewToggleButton;
		JToggleButton tglbtnNewToggleButton_1;
		JToggleButton tglbtnAccolades;
		final ButtonGroup buttonGroupobj = new ButtonGroup();
		tglbtnNewToggleButton = new JToggleButton("Lifetime Totals   ");
		tglbtnNewToggleButton.setSelected(true);
		//show the lifetime total panel  and hide the rest
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(false);
				panelAccolades.setVisible(false);
				panelLifeTime.setVisible(true);

			}
		});
		panel_1.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton.setOpaque(true);	
		buttonGroupobj.add(tglbtnNewToggleButton);

		//add button Best days
		tglbtnNewToggleButton_1 = new JToggleButton("Best Days           ");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			//show the best days panel  and hide the rest
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(true);
				panelAccolades.setVisible(true);
				panelLifeTime.setVisible(false);

			}
		});
		tglbtnNewToggleButton_1.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton_1.setOpaque(true);	
		panel_1.add(tglbtnNewToggleButton_1);
		buttonGroupobj.add(tglbtnNewToggleButton_1);

		//add button Accolades
		tglbtnAccolades = new JToggleButton("Accolades          ");
		panel_1.add(tglbtnAccolades);
		tglbtnAccolades.setBackground(new Color(55,55,55));
		//show the Accolades panel  and hide the rest
		tglbtnAccolades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(false);
				panelAccolades.setVisible(true);
				panelLifeTime.setVisible(false);

			}
		});
		tglbtnAccolades.setOpaque(true);	
		buttonGroupobj.add(tglbtnAccolades);


		//Add a vertical Glue so the Settings option is at the bottom of the tab bar on the left
		//	Figure out how to do this
		//

		/**
		 * settings
		 * 
		 */
		//create a settings panel
		JComponent panel4 = makeTextPanel( "Settings");
		// create the label settings on tpo
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(SystemColor.inactiveCaption);
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblSettings.setBounds(44, 6, 257, 72);
		panel4.add(lblSettings); 
		//create the units  label
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblUnits.setForeground(SystemColor.inactiveCaption);
		lblUnits.setBounds(101, 95, 61, 16);
		panel4.add(lblUnits);	

		//create the time format label
		JLabel lblTimeFormat = new JLabel("Time format");
		lblTimeFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblTimeFormat.setForeground(SystemColor.inactiveCaption);
		lblTimeFormat.setBounds(101, 147, 118, 16);
		panel4.add(lblTimeFormat);
		//create the data format label 

		JLabel lblDateFormat = new JLabel("Date format");
		lblDateFormat.setForeground(SystemColor.inactiveCaption);
		lblDateFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblDateFormat.setBounds(101, 195, 118, 16);
		panel4.add(lblDateFormat);

		//create the Languages label
		JLabel lblLanguages = new JLabel("Languages");
		lblLanguages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblLanguages.setForeground(SystemColor.inactiveCaption);
		lblLanguages.setBounds(101, 232, 118, 33);
		panel4.add(lblLanguages);
		//create the Pages label
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblPages.setForeground(SystemColor.inactiveCaption);
		lblPages.setBounds(101, 274, 93, 35);
		panel4.add(lblPages);
		//add a comboBox for the dateformat
		String[] dateformat= {"dd/mm/yyyy","mm/dd/yyyy"};
		JComboBox comboBox = new JComboBox(dateformat);
		comboBox.setBounds(262, 195, 140, 27);
		panel4.add(comboBox);

		//add a comboBox for the langauges

		String[] language= {"English","French"};
		JComboBox comboBox_1 = new JComboBox(language);
		comboBox_1.setBounds(262, 235, 140, 27);
		panel4.add(comboBox_1);
		//add a checkbox for pages
		JCheckBox chckbxTimeSeriesData = new JCheckBox("Time series data");
		chckbxTimeSeriesData.setForeground(Color.WHITE);
		chckbxTimeSeriesData.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxTimeSeriesData.setBounds(262, 274, 177, 23);
		panel4.add(chckbxTimeSeriesData);

		JCheckBox chckbxHeartRateZones = new JCheckBox("Heart rate zones");
		chckbxHeartRateZones.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxHeartRateZones.setForeground(Color.WHITE);
		chckbxHeartRateZones.setBounds(262, 310, 177, 23);
		panel4.add(chckbxHeartRateZones);

		JCheckBox chckbxMap = new JCheckBox("Map");
		chckbxMap.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxMap.setForeground(Color.WHITE);
		chckbxMap.setBounds(262, 346, 128, 23);
		panel4.add(chckbxMap);

		JCheckBox chckbxDailyGoals = new JCheckBox("Daily Goals");
		chckbxDailyGoals.setForeground(Color.WHITE);
		chckbxDailyGoals.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxDailyGoals.setBounds(262,380, 155, 23);
		panel4.add(chckbxDailyGoals);
		//add a radiobutton for the units
		JRadioButton rdbtnMetric = new JRadioButton("Metric");
		ButtonGroup buttonGroup = new ButtonGroup();
		ButtonGroup buttonGroup_1 = new ButtonGroup();
		buttonGroup.add(rdbtnMetric);
		rdbtnMetric.setSelected(true);
		rdbtnMetric.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnMetric.setForeground(Color.WHITE);
		rdbtnMetric.setBounds(262, 95, 141, 23);
		panel4.add(rdbtnMetric);

		//add a radiobutton for the time format
		JRadioButton rdbtnhourClock = new JRadioButton("12-hour clock");
		buttonGroup_1.add(rdbtnhourClock);
		rdbtnhourClock.setSelected(true);
		rdbtnhourClock.setForeground(Color.WHITE);
		rdbtnhourClock.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock.setBounds(262, 147, 155, 23);
		panel4.add(rdbtnhourClock);

		//add a radiobutton for the time format
		JRadioButton rdbtnhourClock_1 = new JRadioButton("24-hour clock");
		buttonGroup_1.add(rdbtnhourClock_1);
		rdbtnhourClock_1.setForeground(Color.WHITE);
		rdbtnhourClock_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock_1.setBounds(460, 147, 177, 23);
		panel4.add(rdbtnhourClock_1);

		//add a radiobutton for the units
		JRadioButton rdbtnImperial = new JRadioButton("Imperial");
		buttonGroup.add(rdbtnImperial);
		rdbtnImperial.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnImperial.setForeground(Color.WHITE);
		rdbtnImperial.setBounds(460, 95, 141, 23);
		panel4 .add(rdbtnImperial);
		JPanel panelback = new JPanel();
		panelback.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelback.setBackground(new Color(40, 40, 40));
		panelback.setForeground(new Color(40, 40, 40));
		panelback.setBounds(18, 77, 1110, 567);
		panel4.add(panelback, BorderLayout.WEST);

		panel4.setPreferredSize(new Dimension(410, 50));

		ImageIcon icon = new ImageIcon("settings_icon.png");
		tabbedPane.addTab("Settings", icon, panel4, "tmp4");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);

		tabbedPane.setBackgroundAt(3, Color.WHITE);

		// PLace the tab to the left
		tabbedPane.setTabPlacement(tabbedPane.LEFT);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// Set the Attributes
		tabbedPane.setOpaque(true);

		//tabbedPane.setForeground(Color.WHITE);	Discuss the colors we want with the tabs
		tabbedPane.setBackground(new Color(70,70,70));

		//Add the tabbed pane to this panel.
		this.add(tabbedPane);
	}
	/**
	 * a method that will create  panel 
	 * @param text
	 * @return
	 */
	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setBackground(new Color (55,55,55));
		panel.setLayout(null);
		return panel;
	}
}