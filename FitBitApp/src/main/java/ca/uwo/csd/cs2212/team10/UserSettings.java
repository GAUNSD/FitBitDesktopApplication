package ca.uwo.csd.cs2212.team10;

import java.io.Serializable;

public class UserSettings implements Serializable
{
	private String units = "metric";

	public UserSettings()
	{
		this.units = units;
	}

	@Override
	public String toString()
	{
		return "UserSettings [units=" + units + "]";
	}

	public String getUnits()
	{
		return units;
	}

	public void setUnits(String units)
	{
		this.units = units;
	}
}
