package ca.uwo.csd.cs2212.team10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main
{
    static Logger logger = LogManager.getLogger (Main.class.getName());

    public static void main (String[] args)
    {
        logger.trace("Entering main");
        logger.warn("Hello Maven/log4j World!");
        logger.info("Our team name is team10");

        // Test: Open Dashboard window from main
        DashboardMenu frame = new DashboardMenu(); 
        frame.setVisible(true);
        
        // Test: call main from Fitbit class
        Fitbit.main(null);
        

        logger.trace("Exiting main");
    }
}
