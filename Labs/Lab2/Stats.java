import java.util.*;
public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}


	private static int fillUp (int List[])
		{
			Scanner in = new Scanner (System.in);
			int current= in.nextInt();
			int numItems=0;

			while (true)
			{
				if((current==0)||(numItems==MAX_SIZE))
				{
					break;
				}
				
				List[numItems++] = current;
				current=in.nextInt();		
			
			}
			return numItems;

		}


	private static  int range (int List[], int numItems)
	{
	
		int smallest= List[0];	
		int largest=List[numItems];

		for (int i=0; i<numItems; i++)
		{
			if (List[i]<smallest)
			{
				smallest=List[i];
				
			}
			else if (List[i]>largest)
			{
				largest=List[i];
			}			 	
		}
		
		int range= largest-smallest;
		return range;		
	}

	private static double mean (int List[], int numItems)
	{
		int total=0;
		for (int i=0; i<numItems; i++)
		{
			total=total+List[i];	
		}
		
		double mean= total/numItems;

		return mean;

	}

	





}
