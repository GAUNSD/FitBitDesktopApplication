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
        logger.trace("Exiting main");
    }
}
