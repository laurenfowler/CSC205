import java.util.*;

public class Clock {

	final static int HOURS_IN_DAY = 24,
			 MINUTES_IN_HOUR = 60,
			 SECONDS_IN_MINUTE = 60;

	//these are private because I don't want anyone to mess with set times
	private int hours, minutes, seconds;

	//constructor
	public Clock (int hours, int minutes, int seconds)
	{ 
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}  
	
	//default constructor with no parameters
	public Clock ()
	{
		hours=0;
		minutes=0;
		seconds=0;
	}

	public void reset()
	{
		hours=0;
		minutes=0;
		seconds=0;
	}

	//overloaded method because parameters
	public void reset(int hours, int minutes, int seconds)
	{
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}
	
	public void advance()
	{
		seconds=seconds+1;
							
		if (seconds==SECONDS_IN_MINUTE)
			{
				minutes++;
				seconds=0;
			}
		if (minutes==MINUTES_IN_HOUR)
			{
				hours++;
				minutes=0;
			}
		if (hours==HOURS_IN_DAY)
			{
				hours=0;
			}
	}	

	public String toString()
		{
			return hours + ":" + minutes + ":" + seconds; 
		}

		


}
