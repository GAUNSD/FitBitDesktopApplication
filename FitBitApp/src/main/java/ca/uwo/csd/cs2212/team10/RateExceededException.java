package ca.uwo.csd.cs2212.team10;

/**
 * This class will be used to handle exceptions when the rate limit is exceeded
 * @author pears
 *
 */
public class RateExceededException extends Exception
{
	/**
	 * Exception constructor
	 * @param message
	 */
	public RateExceededException(String message)
	{
		super(message);
	}
}
