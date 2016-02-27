package ca.uwo.csd.cs2212.team10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class DashboardMenu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnHome;
	private JButton btnOptions;
	private JButton btnStats;
	private JTextField textField_1;

	private JButton button;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardMenu frame = new DashboardMenu();
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
	public DashboardMenu() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setResizable(false);
		setTitle("FitBit");
		contentPane.setBackground(new Color(55, 55, 55));
		contentPane.setForeground(new Color(55, 55, 55));
		setBounds(100, 100, 1043, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		ImageIcon img0=new ImageIcon("src/main/resources/fitbitlogo.png");
		lblNewLabel.setIcon(img0);
		lblNewLabel.setBounds(460, 6, 177, 38);
		contentPane.add(lblNewLabel);
		
		

		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBackground(new Color(87, 87, 87));
		textField.setBounds(-7, -11, 1060, 72);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		ImageIcon img3=new ImageIcon("src/main/resources/settings_icon.png");
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
		
		JLabel lblSettings = new JLabel("Dashboard Menu");
		lblSettings.setForeground(SystemColor.inactiveCaption);
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblSettings.setBounds(79, 68, 436, 72);
		contentPane.add(lblSettings);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(40, 40, 40));
		scrollPane.setForeground(new Color(40, 40, 40));
		scrollPane.setBounds(79, 152, 945, 492);
		contentPane.add(scrollPane);
		JLabel label = new JLabel();
		label.setBackground(new Color(0, 128, 128));
		scrollPane.setViewportView(label);
		
		panel = new JPanel();
panel.setBounds(79, 152, 945, 492);
panel.setBackground(new Color(40, 40, 40));
panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));

scrollPane.setViewportView(panel);
panel.setLayout(new BorderLayout(0, 0));
chckbxNewCheckBox = new JCheckBox("New check box");
chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
panel.add(chckbxNewCheckBox, BorderLayout.NORTH);
chckbxNewCheckBox_1 = new JCheckBox("New check box");
panel.add(chckbxNewCheckBox_1, BorderLayout.EAST);
chckbxNewCheckBox_2 = new JCheckBox("New Check box");
chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.RIGHT);
panel.add(chckbxNewCheckBox_2, BorderLayout.SOUTH);
		
		
		
		
		
		
	}

}
