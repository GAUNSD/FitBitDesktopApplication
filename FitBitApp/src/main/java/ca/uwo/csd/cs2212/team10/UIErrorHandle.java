package ca.uwo.csd.cs2212.team10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * A Class that represents the Error handling panel within the UI.
 * This Screen will display relevant information needed for error handling.
 * Errors include:
 * 		Failed API Calls
 * 		.
 * 		.
 * 		.
 * @author Gustavo Murcia
 *
 */
public class UIErrorHandle extends JPanel {
	
	
	public UIErrorHandle ()	{
		
	}
	
	public static void main(String[] args) {
		// Here - for test purposes - we will replicate the MainWindow class
		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("Fit Bit");
		mainWindow.setSize(1230, 685); // The screen size should be 16x9; We use a scale factor of 75
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setBackground(new Color(55, 55, 55));
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the menu bar
		/////////////////////////////////////////////////////////////////////
		// Create the Top Menu Bar and set its attributes
		MyMenuBar topMenubar = new MyMenuBar();
		topMenubar.setBackground(new Color(87, 87, 87));
		topMenubar.setPreferredSize(new Dimension(1200, 70)); // height

		// Create the 'User Name' menu item. Here the user will be able to exit or logout (expand options in the future)
		JMenu mnuUserName = new JMenu("Window");
		mnuUserName.setForeground(Color.WHITE);
		mnuUserName.setBackground(Color.WHITE);
		mnuUserName.setMnemonic(KeyEvent.VK_F);
		/*
		// Under 'User Name': Logout
		//	this lets the user logout. Takes them to the Sign in page
		JMenuItem mniUserNameLogout = new JMenuItem("Log Out");
		mniUserNameLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Will be linked to the sign in page in the future
			}
		});
		*/
		//..
		// Also under 'User Name': Exit
		//	This lets the user exit the program entirely. (implement the exiting also singing them out and saving settings)
		JMenuItem mniUserNameExit = new JMenuItem("Exit");
		mniUserNameExit.setMnemonic(KeyEvent.VK_E);
		mniUserNameExit.setToolTipText("Exit application");
		mniUserNameExit.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0); }
		});
		
		// Add the sub-menu items to the dropdown menu
		//mnuUserName.add(mniUserNameLogout);	// implement in the future
		mnuUserName.add(mniUserNameExit);

		// Add all the created elements to their respective containers
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img0=new ImageIcon("src/main/resources/fitbitlogo.png");
		lblNewLabel.setIcon(img0);
		topMenubar.add(lblNewLabel);
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		topMenubar.add(mnuUserName);
	
		///////////////////////////
		// Add it to the main window
		mainWindow.setJMenuBar(topMenubar);
		/////////////////////////////////////////////////////////////////////
		
		// Create the Main Tab Window. This JPanel will be used to navigate through the window
		//MainTabWindow mainTabWindow = new MainTabWindow(fitbit);
		JPanel mainTabWindow = new JPanel();
		mainWindow.getContentPane().add(mainTabWindow, BorderLayout.CENTER);
		
	}
	

}
/////////////////////////////////////////////////////////////////////////////////////////


