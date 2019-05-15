public class mySums
{
	public static void main (String [] args)
	{
		double iterSum=iterativeSum(4);
		System.out.println(iterSum);
		double recurSum=recurSum(4);
		System.out.println(recurSum);
	}

	//its not adding the one for some reason
	public static double iterativeSum(int n)
	{
		double sum=0;
		for (int i=1; i<=n; i++)
		{
			sum= sum + Math.pow(2, i)+1;
		}
		return sum;
	}

	public static double recurSum(int n)
	{
		//base case
		if (n<1)
		   return 0;
		else 
		   return Math.pow(2, n)+1 + recurSum(n-1);
		
	}
}
