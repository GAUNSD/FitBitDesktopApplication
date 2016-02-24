package ca.uwo.csd.cs2212.team10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;

public class Settings extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnLogOut;
	private JPanel panel;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnHome;
	private JButton btnOptions;
	private JButton btnStats;
	private JButton button;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setResizable(false);
		contentPane.setEnabled(false);
	setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("FitBit");
		contentPane.setBackground(new Color(55, 55, 55));
		contentPane.setForeground(new Color(55, 55, 55));
		setBounds(100, 100, 1043, 680);
		contentPane.setLayout(null);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnLogOut.setBounds(963, 6, 74, 39);
		
		contentPane.add(btnLogOut);

		

		lblNewLabel = new JLabel("New label");
		ImageIcon img0=new ImageIcon("src/main/resources/fitbitlogo.png");
		lblNewLabel.setIcon(img0);
		lblNewLabel.setBounds(460, 6, 177, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBackground(new Color(87, 87, 87));
		textField.setBounds(-7, -11, 1060, 72);
		contentPane.add(textField);
		

		//The home button (I still need an image for that) 
		btnHome = new JButton("");
		ImageIcon img=new ImageIcon("src/main/resources/home_icon.jpg");
		btnHome.setIcon(img);
		btnHome.setBounds(6, 83, 41, 41);
		contentPane.add(btnHome);
		
		//The options button (I still need an image for that) 
		btnOptions = new JButton("");
		ImageIcon img1=new ImageIcon("src/main/resources/options_icon.jpg");
		btnOptions.setIcon(img1);	
		btnOptions.setBounds(6, 130, 41, 41);
		contentPane.add(btnOptions);
		
		//The stats button (I still need an image for that) 
		btnStats = new JButton("");
		ImageIcon img2=new ImageIcon("src/main/resources/stats_icon.jpg");
		btnStats.setIcon(img2);
		btnStats.setBounds(6, 180, 41, 41);
		contentPane.add(btnStats);
		
		button = new JButton("");
		ImageIcon img3=new ImageIcon("src/main/resrouces/settings_icon.png");
		button.setIcon(img3);
		button.setBackground(new Color(71, 71, 71));
		button.setBorderPainted(false);
		button.setBounds(6, 611, 41, 41);
		
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(71, 71, 71));
		textField_1.setBounds(-7, 20, 74, 660);
		contentPane.add(textField_1);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(SystemColor.inactiveCaption);
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblSettings.setBounds(79, 68, 257, 72);
		contentPane.add(lblSettings);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblUnits.setForeground(SystemColor.inactiveCaption);
		lblUnits.setBounds(101, 177, 61, 16);
		contentPane.add(lblUnits);
		
		JLabel lblTimeFormat = new JLabel("Time format");
		lblTimeFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblTimeFormat.setForeground(SystemColor.inactiveCaption);
		lblTimeFormat.setBounds(101, 205, 118, 16);
		contentPane.add(lblTimeFormat);
		
		JLabel lblDateFormat = new JLabel("Date format");
		lblDateFormat.setForeground(SystemColor.inactiveCaption);
		lblDateFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblDateFormat.setBounds(101, 247, 118, 16);
		contentPane.add(lblDateFormat);
		
		JLabel lblLanguages = new JLabel("Languages");
		lblLanguages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblLanguages.setForeground(SystemColor.inactiveCaption);
		lblLanguages.setBounds(101, 287, 118, 33);
		contentPane.add(lblLanguages);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblPages.setForeground(SystemColor.inactiveCaption);
		lblPages.setBounds(101, 348, 93, 35);
		contentPane.add(lblPages);
		
		String[] dateformat= {"dd/mm/yyyy","mm/dd/yyyy"};
		JComboBox comboBox = new JComboBox(dateformat);
		comboBox.setBounds(262, 243, 140, 27);
		contentPane.add(comboBox);
		
		JList list = new JList();
		list.setBounds(301, 319, 101, -21);
		contentPane.add(list);
		
		String[] language= {"English","French"};
		JComboBox comboBox_1 = new JComboBox(language);
		comboBox_1.setBounds(262, 293, 140, 27);
		contentPane.add(comboBox_1);
		
		JCheckBox chckbxTimeSeriesData = new JCheckBox("Time series data");
		chckbxTimeSeriesData.setForeground(Color.WHITE);
		chckbxTimeSeriesData.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxTimeSeriesData.setBounds(262, 354, 177, 23);
		contentPane.add(chckbxTimeSeriesData);
		
		JCheckBox chckbxHeartRateZones = new JCheckBox("Heart rate zones");
		chckbxHeartRateZones.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxHeartRateZones.setForeground(Color.WHITE);
		chckbxHeartRateZones.setBounds(262, 389, 177, 23);
		contentPane.add(chckbxHeartRateZones);
		
		JCheckBox chckbxMap = new JCheckBox("Map");
		chckbxMap.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxMap.setForeground(Color.WHITE);
		chckbxMap.setBounds(262, 424, 128, 23);
		contentPane.add(chckbxMap);
		
		JCheckBox chckbxDailyGoals = new JCheckBox("Daily Goals");
		chckbxDailyGoals.setForeground(Color.WHITE);
		chckbxDailyGoals.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxDailyGoals.setBounds(262, 459, 155, 23);
		contentPane.add(chckbxDailyGoals);
		
	JRadioButton rdbtnMetric = new JRadioButton("Metric");
	buttonGroup.add(rdbtnMetric);
	rdbtnMetric.setSelected(true);
		rdbtnMetric.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnMetric.setForeground(Color.WHITE);
		rdbtnMetric.setBounds(262, 175, 141, 23);
		contentPane.add(rdbtnMetric);
		
		JRadioButton rdbtnhourClock = new JRadioButton("12-hour clock");
		buttonGroup_1.add(rdbtnhourClock);
		rdbtnhourClock.setSelected(true);
		rdbtnhourClock.setForeground(Color.WHITE);
		rdbtnhourClock.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock.setBounds(262, 203, 155, 23);
		contentPane.add(rdbtnhourClock);
		
		JRadioButton rdbtnhourClock_1 = new JRadioButton("24-hour clock");
		buttonGroup_1.add(rdbtnhourClock_1);
		rdbtnhourClock_1.setForeground(Color.WHITE);
		rdbtnhourClock_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock_1.setBounds(460, 203, 177, 23);
		contentPane.add(rdbtnhourClock_1);
		
		JRadioButton rdbtnImperial = new JRadioButton("Imperial");
		buttonGroup.add(rdbtnImperial);
		rdbtnImperial.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnImperial.setForeground(Color.WHITE);
		rdbtnImperial.setBounds(453, 175, 141, 23);
		contentPane.add(rdbtnImperial);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel.setBackground(new Color(40, 40, 40));
		panel.setForeground(new Color(40, 40, 40));
		panel.setBounds(79, 152, 945, 492);
		contentPane.add(panel, BorderLayout.WEST);
		
		
		
	}

}
