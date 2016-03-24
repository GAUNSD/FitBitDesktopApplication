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
	
	String label;
	
	/**
	 * UIError constructor.
	 * This is a JPanel that will display information when there is an error
	 */
	public UIErrorHandle() {
		
		// Create the label that shows the information
		this.setLabel("tmp");
		JTextArea lblName = new JTextArea(this.getLabel());
		lblName.setEditable(false);
		lblName.setBackground(new Color(150, 150, 150));
		lblName.setForeground(new Color(139,24,32));
		// Set the panels attributes
		this.add(lblName);
		this.setBackground(null);
	}
	
	/**
	 * Mutator to create the String Label that shows the errors.
	 * 
	 * @return String
	 */
	public void setLabel(String in) {
		this.label = in;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public void updateText() {
		this.update(this.getGraphics());
		this.revalidate();
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
		
		// Create the UIErrror Handling Panel.
		UIErrorHandle uiError = new UIErrorHandle();
		

		// Create the 'User Name' menu item. Here the user will be able to exit or logout (expand options in the future)
		JMenu mnuUserName = new JMenu("Window");
		mnuUserName.setForeground(Color.WHITE);
		mnuUserName.setBackground(Color.WHITE);
		mnuUserName.setMnemonic(KeyEvent.VK_F);
		
		// Also under 'User Name': Exit
		//	This lets the user exit the program entirely. (implement the exiting also singing them out and saving settings)
		JMenuItem mniUserNameExit = new JMenuItem("Exit");
		mniUserNameExit.setMnemonic(KeyEvent.VK_E);
		mniUserNameExit.setToolTipText("Exit application");
		mniUserNameExit.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent event) {
				uiError.setLabel("Hello");
				uiError.updateText(); }
		});
		
		// Add the sub-menu items to the dropdown menu
		//mnuUserName.add(mniUserNameLogout);	// implement in the future
		mnuUserName.add(mniUserNameExit);

		// Add all the created elements to their respective containers
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img0=new ImageIcon("src/main/resources/fitbitlogo.png");
		topMenubar.add(uiError);
		//topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		topMenubar.add(Box.createRigidArea(new Dimension(20,0))); // This rigidly spaces out the eiError and the space
		
		lblNewLabel.setIcon(img0);
		topMenubar.add(lblNewLabel);
		topMenubar.add(Box.createHorizontalGlue()); // This spaces out the menu item so it's to the left
		topMenubar.add(mnuUserName);
	
	
		// Add it to the main window
		mainWindow.setJMenuBar(topMenubar);
		/////////////////////////////////////////////////////////////////////
		
		// Create the Main Tab Window. This JPanel will be used to navigate through the window
		//MainTabWindow mainTabWindow = new MainTabWindow(fitbit);
		JPanel mainTabWindow = new JPanel();
		mainWindow.getContentPane().add(mainTabWindow, BorderLayout.CENTER);
		
		mainWindow.setVisible(true);
		
	}
	

}
/////////////////////////////////////////////////////////////////////////////////////////


