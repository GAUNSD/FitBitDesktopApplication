package ca.uwo.csd.cs2212.team10;

import java.io.Serializable;

public class UserSettings implements Serializable
{
	private String units = "metric";

	@Override
	public String toString()
	{
		return "UserSettings [units=" + units + "]";
	}

	public UserSettings()
	{
		this.units = units;
	}
}
