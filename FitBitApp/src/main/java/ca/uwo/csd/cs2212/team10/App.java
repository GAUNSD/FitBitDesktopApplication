package ca.uwo.csd.cs2212.team10;

import javax.swing.SwingUtilities;

import org.json.JSONException;
import java.io.IOException; 

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override

			public void run() {
				MainWindow window = null;
                Maps.main(null);
				try {
					window = new MainWindow();
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
