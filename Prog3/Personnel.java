import java.util.*;
import java.io.*;

public class Personnel
{
   public static void main (String[] args)
   {
	//initialize employee arraylist
	ArrayList<Employee> database = new ArrayList<Employee>();
   	
	char option=displayMenu();
	while(option != 'q' &&  option != 'Q')
	{		     		
	switch(option)
	{
		case 'n': 
		case 'N':
			  Employee employee= getInfo();
			  database.add(employee);
			  break;
		case 'c':
		case 'C':
			  calculatePay(database);
			  break;
		
		case 'r': 
		case 'R':
			  raiseWages(database);
			  break;

		case 'p':  
		case 'P':
			  printRecords(database);
			  break;

		case 'd':
		case 'D':
			  downData(database);
			  break;
		case 'u':
		case 'U':
			  uploadData(database);
			  break;
				
		default: 
			System.out.println("Not a valid input");
	                break;

	}
	
	option=displayMenu();
	}
   }


	//Prints out Menu Options
	public static char displayMenu()
	{
		System.out.println("----------------------------------------");
		System.out.println("|                                      |");
		System.out.println("|Commands: n - new employee            |");
		System.out.println("|          c - Compute paychecks       |");    
		System.out.println("|          r - Raise wages             |"); 
		System.out.println("|          p - Print records           |");
		System.out.println("|          d - Download data           |");
		System.out.println("|          u - Upload data             |");
		System.out.println("|          q - Quit                    |");
		System.out.println("|                                      |");
		System.out.println("----------------------------------------");
		
		Scanner in=new Scanner(System.in);
		char option=in.nextLine().charAt(0); 
		return option; 					
	}
		
	//gets the name, type, and salary of new employee
	public static Employee getInfo()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the name of the New Employee");
		String name= in.nextLine(); 
		System.out.println("Enter h for hourly employee, enter s for salaried");
		char type=in.nextLine().charAt(0); 
		double wage=0;		

		if(type=='h' || type=='H')
		{
			System.out.println("Enter hourly wage");
			wage=in.nextDouble(); //in.nextLine();
			
		}
		else if(type=='s' || type== 'S')
		{
			System.out.println("Enter annual salary");
			wage=in.nextDouble(); //in.nextLine();
		}
		
	//calls newEmployee method
		Employee employ=newEmployee(name, type, wage);
		return employ;	

	}

	
	//new Employee method
	public static Employee newEmployee(String name , char type, double wage)
	{
		Employee employ = null;
		if (type=='s' || type== 'S')
		{
			employ= new SalariedEmployee(name, wage);			 	
		}	
		else if (type=='h' || type== 'H' )
		{
			employ=new HourlyEmployee(name, wage);
		}
		else 
			System.out.println("Incorret input");

		return employ;

		
	}

	//compute paychecks
	public static void calculatePay(ArrayList<Employee> database)
	{	
		Scanner in=new Scanner(System.in);	
		double hoursWorked=0;
		//String x;
		for(int i=0; i<database.size(); i++)
		{
			System.out.println("Please enter the hours worked by " + database.get(i).getName() );
			hoursWorked=in.nextDouble(); in.nextLine();
			String pay= toDollars(database.get(i).computePay(hoursWorked));
			System.out.println("Pay: " + pay);
		} 		
		
	}

	public static void raiseWages(ArrayList <Employee> database)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter percentage increase");
		double percent=in.nextDouble(); in.nextLine();
		for (int i=0; i<database.size(); i++)
		{
			database.get(i).setRaise(percent);
			System.out.println(database.get(i));
		}	

	}

	public static void printRecords(ArrayList <Employee> database)
	{
		for (int i=0; i<database.size(); i++)
		{
			System.out.println(database.get(i));	
		}
	}	

	public static void downData(ArrayList<Employee> database)	
	{
        String fileName = "Employee.dat";
	//database=null; 
        try {
          //Employee[] peeps = null;
	  ArrayList<Employee> temp = new ArrayList<Employee>();
	  FileInputStream fileIn =
            new FileInputStream(fileName);
          ObjectInputStream in =
            new ObjectInputStream(fileIn);
           temp = (ArrayList<Employee>)in.readObject();
          in.close();
	  for(int i=0; i<temp.size(); i++)
		database.add(temp.get(i));
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
          System.out.println(e.getMessage());
        }
        
	}

	public static void uploadData(ArrayList <Employee> database)
	{
	String fileName = "Employee.dat";
	
        try {
          FileOutputStream fileOut =
            new FileOutputStream(fileName);
          ObjectOutputStream out =
            new ObjectOutputStream(fileOut);
          out.writeObject(database);
          out.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());	
	}
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
