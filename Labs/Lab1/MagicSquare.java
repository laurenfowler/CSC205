import java.util.*;
import java.io.*;


public class MagicSquare {


	public static void main (String[] args) throws IOException {

		File magic1=new File("magic1.txt");
		Scanner in=new Scanner(magic1);

		int [] input=new int[9];

		int a=0;
		
		while (in.hasNextInt())
		{
			input[a]=in.nextInt();
			a++;
		}

		//create matrix
		int [][] magic= new int [3][3];

		int r=0;
		for (int i=0; i<magic.length; i++)
		{
			for (int j=0; j<magic.length; j++)
			{
				magic[i][j]=input[r];
				r++;
			}

		}

	
		//matrix to hold value of added row, column, diagonal
		int [] sums = new int [8];

		int x=0;
		for (int i=0; i<magic.length; i++)
		{
			int rowSum=0;
			for (int j=0; j<magic.length; j++)
			{
				rowSum=rowSum + magic[i][j];
			}
			sums[x]=rowSum;
			x++;	
		}

		int b=3;
		for (int j=0; j<magic.length; j++)
		{
			int colSum=0; 
			for (int i=0; i<magic.length; i++)
			{
				colSum=colSum + magic [i][j];
			}
			sums[b]=colSum;
			b++;
		}

			

		//top left to bottom right
		
		
		int dsum1= 0;
		for (int i=0; i<magic.length; i++)
		{
			dsum1= dsum1 + magic [i][i];
		}	
		sums[6]=dsum1;

		//top right to bottom left

		int dsum2=0;
		for (int i=0; i<magic.length; i++)
		{
			dsum2= dsum2 + magic[i][magic.length-i-1];
		}
		sums[7]=dsum2;


		//compares values in sums matrix
	
		int h=0;
	 	for (int i=0; i<sums.length-1; i++)
		{
			if (sums[i]==sums[i+1])
			{
				h++;
			}	
		}

		
		if (h==7)
		{
			System.out.println("It is a magic square");
		}
		else 
		{
			System.out.println("It is not a magic square");
		}
		



	}

}
