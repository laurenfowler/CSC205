
public class Puzzle
{
	
	public static void main(String[] args)
        {	
		puzzle(9);
	}

	private static int puzzle (int n)
	{
		int returned;
		
		for (int i=1; i<=4-n; i++)
			System.out.print("\t");
        	if ( (n % 3) == 2 )
		{
		//	System.out.println("Base case reached//puzzle(2) = returns 1");
           		returned=1;
		}
	    	else if ( (n % 3) == 1 )
		{
				
			System.out.println("Puzzle " + n + " = Puzzle(" + (n+1) + ") + 2"); 
			returned= (puzzle (n+1) +2);
		}	
        	else
		{			
			System.out.println("Puzzle " + n + "= Puzzle(" + (n/3) + ") + 1"); 	
			returned=(puzzle (n/3) +1); 
		}
		 for (int i=1; i<=4-n; i++)
			System.out.print("\t");
         	 System.out.println("Puzzle(" + n + ") returns = " +returned);
		 return returned;
	}
}
