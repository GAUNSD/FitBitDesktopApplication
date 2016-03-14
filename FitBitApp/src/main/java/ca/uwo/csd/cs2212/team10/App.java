package ca.uwo.csd.cs2212.team10;

import javax.swing.SwingUtilities;

import org.json.JSONException;

/**
 * This is the main class that is run by the jar. 
 * All arguments are passed into here, and the main app window is run here. 
 * @author UI Team
 */
public class App {
	
    /**
     * Main method opens the main window of the app
     * @param args String array that will contain any arguments passed when the jar is run, including the "-test" parameter. 
     */
    public static void main(String[] args) {
		
        // Set up test case
        final boolean test = false; 
       if(args[0].equals("-test")) test = true;  

    	SwingUtilities.invokeLater(new Runnable() {
			@Override
            
            /**
             * Opens new main window
             */ 
			public void run() {
				MainWindow window = null;
				try {
					Fitbit fitbit;
					if (test)
						fitbit = new FitbitTest();
					else
						fitbit = new FitbitAPI();
					window = new MainWindow(fitbit);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TokensException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.setVisible(true);
			}
		});
	}
}
