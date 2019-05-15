import java.io.Serializable;
public class SalariedEmployee extends Employee implements Serializable
{
	private double fixedHours=40;
	private double fixedYear=2080;
	double Salary;

	public SalariedEmployee(String name, double hourlyWage)
	{
		super(name, (hourlyWage/2080));
	}

	//returns salary	
	public double getSalary()
	{
		Salary=getWage()*fixedYear;
		return Salary;
	}

	//sets salary
	public void setSalary(double setSalary)
	{
		Salary= setSalary; 		
	}

	
	public double computePay(double hoursWorked)
	{			
		return(getSalary()/52);	
	}

	public String toString()
	{
		String name=getName();
		double salary=getSalary();
		String dollars=toDollars(salary);
		int pad=35-dollars.length();
		return pad(name, pad) + dollars+"/year";
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
