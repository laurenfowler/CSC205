import java.io.Serializable;
public class HourlyEmployee extends Employee implements Serializable
{
	double hoursWorked;	

	public HourlyEmployee(String name, double hourlyWage)
	{
		super(name, hourlyWage);
	}

	public double computePay(double hoursWorked)
	{	
		this.hoursWorked=hoursWorked;
		double wage=getWage();
		double weekWage;
		double overtime=0;
		double extraPay;
		double incrWage=wage*1.5;

		if(hoursWorked<=40.0)
			weekWage=wage*hoursWorked;
		else
			overtime=hoursWorked-40.0;
			extraPay=overtime*incrWage;
			weekWage=(wage*40) + extraPay;
		
		return weekWage;	
	}


	public String toString()
	{
		String name=getName();
		String dollars=toDollars(getWage());
		int pad=35-dollars.length();
		return pad(name,pad)+ dollars + "/hour";
	}
	
	
	 public static String pad(String str, int n)
	 {
		if (str.length() > n)
			return str.substring(0,n);
		while (str.length() < n)
			str += " ";
		return str;
	}

	public static String toDollars (double amount)
	{
	  long roundedAmount = Math.round(amount * 100);
	  long dollars = roundedAmount / 100;
    	  long cents = roundedAmount % 100;

	    if (cents <= 9)
	      return dollars + ".0" + cents;
	    else
	      return dollars + "." + cents;	
	}
	
}
