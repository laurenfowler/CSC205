public class Factorial
{
	public static void main( String [] args)
	{
		System.out.println(factorialr(3));
		
	}

	private static int factorialr(int n)
	{
		return n* factorialr(n-1);
	}



}
