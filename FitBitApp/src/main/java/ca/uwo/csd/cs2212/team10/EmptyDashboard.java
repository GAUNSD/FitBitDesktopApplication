package ca.uwo.csd.cs2212.team10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmptyDashboard extends JFrame {

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
	private JButton btnadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmptyDashboard frame = new EmptyDashboard();
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
	public EmptyDashboard() {
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
		
		
		
		// The log out button
		btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnLogOut.setBounds(963, 6, 74, 39);
		contentPane.add(btnLogOut);
		
		//The button in the middle
		btnadd = new JButton("+ Add elements to get started");
		btnadd.setForeground(new Color(255, 255, 255));
		btnadd.setBackground(new Color(40, 40, 40));
		btnadd.setBounds(478, 312, 257, 29);
		btnadd.setBorderPainted(false);
		contentPane.add(btnadd);

		
		//This the top bar where the logo is in 
		lblNewLabel = new JLabel("New label");
		ImageIcon img0=new ImageIcon("fitbitlogo.png");
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
		
		ImageIcon img=new ImageIcon("home_icon.jpg");
		btnHome.setIcon(img);
		btnHome.setBounds(6, 83, 41, 41);
		contentPane.add(btnHome);
		
		//The options button (I still need an image for that) 
		btnOptions = new JButton("");
		ImageIcon img1=new ImageIcon("options_icon.jpg");
		btnOptions.setIcon(img1);		
		btnOptions.setBounds(6, 130, 41, 41);
		contentPane.add(btnOptions);
		
		//The stats button (I still need an image for that) 
		btnStats = new JButton("");
		ImageIcon img2=new ImageIcon("stats_icon.jpg");
		btnStats.setIcon(img2);
		btnStats.setBounds(6, 180, 41, 41);
		contentPane.add(btnStats);
		
		//The settings Button
		button = new JButton("");
		ImageIcon img3=new ImageIcon("settings_icon.png");
		button.setIcon(img3);
		//When you click on the settings icon it should open the setting page and close the empty dashboard
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1= new Settings();
				frame1.setVisible(true);	
				dispose(); 
			}
		});
		//// change the reference to where you have the picture in; if you know how we can insert it with an easier way, change it
		button.setBackground(new Color(71, 71, 71));
		button.setBorderPainted(false);
		button.setBounds(6, 611, 41, 41);
		contentPane.add(button);
		

		// the panel in the middle where the elements are gonna be added
		panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel.setBackground(new Color(40, 40, 40));
		panel.setForeground(new Color(40, 40, 40));
		panel.setBounds(85, 68, 939, 570);
		contentPane.add(panel);
		
		//The menu on the left
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(71, 71, 71));
		textField_1.setBounds(-7, 20, 74, 660);
		contentPane.add(textField_1);
		
		
	}



}
