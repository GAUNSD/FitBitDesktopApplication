package ca.uwo.csd.cs2212.team10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.applet.Applet;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Stats extends JFrame {

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
	private JPanel panel_1;
	private JToggleButton tglbtnNewToggleButton;
	private JToggleButton tglbtnNewToggleButton_1;
	private JToggleButton tglbtnAccolades;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stats frame = new Stats();
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
	public Stats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
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
		
		//The settings Button
		button = new JButton("");		
		ImageIcon img3=new ImageIcon("src/main/resources/settings_icon.png");
		button.setIcon(img3);
		button.setBackground(new Color(71, 71, 71));
		button.setBorderPainted(false);
		button.setBounds(6, 611, 41, 41);
		contentPane.add(button);
		

		// the panel in the middle where the elements are gonna be added
		panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel.setBackground(new Color(40, 40, 40));
		panel.setForeground(new Color(40, 40, 40));
		panel.setBounds(240, 75, 783, 570);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		//The menu on the left
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(71, 71, 71));
		textField_1.setBounds(-7, 20, 74, 660);
		contentPane.add(textField_1, BorderLayout.NORTH);
		
	
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setForeground(new Color(40, 40, 40));
		panel_1.setBounds(65, 60, 158, 598);
		contentPane.add(panel_1, BorderLayout.CENTER);
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tglbtnNewToggleButton = new JToggleButton("Lifetime Totals   ");
		tglbtnNewToggleButton.setSelected(true);
		panel_1.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton.setOpaque(true);	
		buttonGroup.add(tglbtnNewToggleButton);
		
		
		tglbtnNewToggleButton_1 = new JToggleButton("Best Days           ");
		tglbtnNewToggleButton_1.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton_1.setOpaque(true);	
		panel_1.add(tglbtnNewToggleButton_1);
		buttonGroup.add(tglbtnNewToggleButton_1);
		
		tglbtnAccolades = new JToggleButton("Accolades          ");
		panel_1.add(tglbtnAccolades);
		tglbtnAccolades.setBackground(new Color(55,55,55));
		tglbtnAccolades.setOpaque(true);	
		buttonGroup.add(tglbtnAccolades);
			
		
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
