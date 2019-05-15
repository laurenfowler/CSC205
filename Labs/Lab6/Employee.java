public class Employee extends Person
{
  private double salary;
  private Date hireDate; 
  private Date birthDate;
  private String firstName;
  private String lastName;
  
  public Employee (String firstName, String lastName, Date birthDate, Date hireDate, double salary)
  {
    super(firstName, lastName, birthDate);
    this.salary=salary;
    this.hireDate=hireDate;
    this.firstName=firstName;
    this.lastName=lastName;
    this.birthDate=birthDate;	
  }

  public double getSalary()
  {
	return salary;
  }

  public Date getHireDate()
  {
	return hireDate;
  }  

  public String toString()
  {
	return lastName + ", "+ firstName + "\n" + "salary= " + salary + "\n"+ "birth= " + birthDate + "\n" + "hireDate= " + hireDate;  
	
  }
  

}

