package ca.uwo.csd.cs2212.team10;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class MainTabbedWindow {

	public MainTabbedWindow() {

		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		ImageIcon icon = new ImageIcon("img/FitBitIconSmall.png");
		

		JComponent panel1 = makeTextPanel("Custom Dashboard");			// NOTE: Panels are the large sections of each tab
																		//These are where all of Leena and Vincent's work comes in
		tabbedPane.addTab("Dashboard", icon, panel1, "tmp1");	// check why icon isn't working
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setBackgroundAt(0, Color.WHITE);

		JComponent panel2 = makeTextPanel("Dashboard Menu");
		tabbedPane.addTab("Menu", icon, panel2, "tmp2");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.setBackgroundAt(1, Color.WHITE);

		JComponent panel3 = makeTextPanel("Stats");
		tabbedPane.addTab("Stats", icon, panel3, "tmp3");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.setBackgroundAt(2, Color.WHITE);

		//Add a vertical Glue so the Settings option is at the bottom of the tab bar on the left
		//	Figure out how to do this
		//

		JComponent panel4 = makeTextPanel( "Settings");
		// From the Oracle Tutorial. This isn't nessecary -as far as i know
		panel4.setPreferredSize(new Dimension(410, 50));
		//
		tabbedPane.addTab("Settings", icon, panel4, "tmp4");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
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

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}