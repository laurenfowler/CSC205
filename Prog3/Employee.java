import java.io.Serializable;
public abstract class Employee implements Serializable
{
  private String name;
  private double hourWage;
	//constructor
	protected Employee(String name, double hourWage)
	{
	  this.name=name;
	  this.hourWage=hourWage;  
	}
	//GETTER METHODS
	public String getName()
	{
	  return name;
	}

	public double getWage()
	{
	  return hourWage;
	}
	
	//SETTER METHODS
	
	//increase hourly wage
	public void  setRaise(double percent)
	{
	   hourWage= hourWage + hourWage*(percent/100);
	}

	public abstract double computePay(double HoursWorked);

}
