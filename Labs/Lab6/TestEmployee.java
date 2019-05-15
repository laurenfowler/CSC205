public class TestEmployee{

  public static void main (String [] args)
  {
	Date hireDate=new Date();
	Date birthDate=new Date(1980, 3, 8);

	Employee morris= new Employee("Morris"," Brown", birthDate, hireDate, 40000.00);

	System.out.println(hireDate);
	System.out.println(birthDate);
	System.out.println(morris);

  }



}
