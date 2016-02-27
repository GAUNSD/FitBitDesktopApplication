package ca.uwo.csd.cs2212.team10;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainWindow extends JFrame{
	
	
	public MainWindow() {
		this.initUI();
	}

	private void initUI() {
		// Create and set up the window with its initial attributes.
		this.setTitle("Fit Bit");
		this.setSize(1200, 675); // The screen size should be 16x9; We use a scale factor of 75
	    this.setLocationRelativeTo(null);
	    this.setBackground(new Color(55, 55, 55));
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	    
	    // Add/Create the Menu Bar using the createMenuBar Method
	  	this.setJMenuBar(this.createMenubar());
	    
	    // Create the Main Tab Window. This JPanel will be used to navigate through the window
 		MainTabbedWindow mainTabWindow = new MainTabbedWindow();
		this.getContentPane().add(mainTabWindow, BorderLayout.CENTER);
	
		//this.pack()	<-- Is this needed? Investigate
	}

	private JMenuBar createMenubar() {
		// Create the Top Menu Bar and set its attributes
		JMenuBar topMenubar = new JMenuBar();
		topMenubar.setOpaque(true);
		topMenubar.setBackground(new Color(87, 87, 87));
		topMenubar.setPreferredSize(new Dimension(1200, 70)); // height 50. higher? or lower?
		
		// Create the 'User Name' menu item. Here the user will be able to exit or logout (expand options in the future)
		JMenu mnuUserName = new JMenu("User Name");
		mnuUserName.setForeground(Color.WHITE);
		mnuUserName.setBackground(Color.WHITE);
		mnuUserName.setMnemonic(KeyEvent.VK_F);
		// Under 'User Name': Logout
		//	this lets the user logout. Takes them to the Sign in page
		JMenuItem mniUserNameLogout = new JMenuItem("Log Out");
		//..
		//	Implement this option taking them to the Sign In in page
		//		Do this by learning how the addActionListener works
		// 		This is the key to adding all the actions
		//..
		
		// Also under 'User Name': Exit
		//	This lets the user exit the program entirely. (implement the exiting also singing them out and saving settings)
		JMenuItem mniUserNameExit = new JMenuItem("Exit");
		mniUserNameExit.setMnemonic(KeyEvent.VK_E);
		mniUserNameExit.setToolTipText("Exit application");
		mniUserNameExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0); }
		});
		
		// Add all the created elements to their respective containers
		mnuUserName.add(mniUserNameLogout);
		mnuUserName.add(mniUserNameExit);
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		topMenubar.add(mnuUserName);
		return topMenubar;	
	}
}
