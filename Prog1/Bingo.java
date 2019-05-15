import java.util.*;
import java.io.*;
import java.io.FileNotFoundException; 
import java.util.BitSet.*;
public class Bingo {

 private static final int ROW=5;
 private static final int COL=5;
 private static int count=0;

 public static void main (String []  args) throws FileNotFoundException{
 //creates card array and array list
 int [][] card= new int [ROW][COL];
 ArrayList<Integer> pulledNums= new ArrayList<Integer> ();
 //creates bitset and sets all to true 
 BitSet bingoNum=new BitSet(76);
 	for (int i=0; i<76; i++)
	  bingoNum.set(i); 	
	 	 
 fillCard(card); 
 printCard(card);
 
 int checkWin;
 checkWin=sumUp(card);
 while (checkWin==0)
	{
	  playGame(card, bingoNum, pulledNums);
	  checkWin=sumUp(card);
	}
 if (checkWin !=0)
 {
	Object[] myArray=pulledNums.toArray();
	for (int b=0; b< myArray.length; b++)
		System.out.print(myArray[b]+ " ");
	System.out.println();
	printWin(checkWin, card);		
 }
	
}

 private static void printWin(int x, int [][] card1)
 {
//precondition: print win takes parameter x, which correlates to
//either a diagnoal,horiziontal, or vertical win
//postcondition: prints out the specific win and calls the print card method

	if (x==1)
	  {
	     System.out.println("Horizontal Win after " + count + " picks!");
	     printCard(card1);
	  }	

	if (x==2)
	  {
	     System.out.println("Vertical Win after " + count + " picks!");
	     printCard(card1);
	  }	

	if (x==3)
	  {
	     System.out.println("Diagonal Win after " + count + " picks!");
	     printCard(card1);
	  }
 }

 private static int [][]  fillCard(int [][] card1 ) throws FileNotFoundException
//precondition: empty array card comes in
//postcondition: sends array card back filled up
//fills bingo card (5x5 arrary) up
 { 
	String bingo= "bingo.in";
	Scanner in=new Scanner(new File(bingo));
	
	while (in.hasNextInt())
	{
		for (int r=0; r<ROW; r++)
			for (int c=0; c<COL; c++)
			{
			  card1[r][c]=in.nextInt();  				
			}
	}

	return card1;
 }

 private static void printCard(int [][] card1)
 {
//precondition: takes filled card as a parameter 
//postcondition: prints out card 
	for (int r=0; r<ROW; r++)
	{
		for (int c=0; c<COL; c++)
		{
		  if (card1[r][c]==0)
		 	 System.out.print("X ");
		  else 
			 System.out.print(card1[r][c]+ "  ");
		}
	System.out.println();
	}
 } 
 

 private static void playGame(int [][] card1, BitSet x, ArrayList<Integer> array)
 {
//precondition: takes card and bitset as a parameter, gets number from pullNum method 
//postcondition: finds valid number, sets it to false, adds to number count and plays game 

        int Num=pullNum();
	  	
	while(x.get(Num)==false)
	{
	   Num=pullNum();
	}   
	 array.add(Num);
	x.clear(Num);	
	count++;
		  
	  for (int r=0; r<ROW; r++)
	  {	
	     for (int c=0; c<COL; c++)
	      {
	     	if (card1[r][c]==Num)
		{
		  card1[r][c]=0;
		 
		 // printCard(card1);	
		}
              }
	   }       		
				   			
}

 private static int pullNum ()
 {
//precondition: pulls a number 
//postcondition: returns a number that has not been pulled

	int pulledNum=(int) (Math.round(Math.random()*74)+1);
	return pulledNum;
		
 }

 private static int sumUp (int [][] card1 )
 {
//precondition: given the card, adds up horizontal, vertical, and diagonols to look for sum of 0
//postcondition: if sum of zero is found, returns specific number, if a sum is not found returns 0

	int isNotBingo=0;
	int isBingoH=1; 
	int isBingoR=2;
	int isBingoD=3;
//sums up horizontal rows	
	
	for (int r=0; r<ROW; r++)
	{
		int sum=0;
		for (int c=0; c<COL; c++)
		{
		  sum=sum+card1[r][c];  		 
		}
	  if (sum==0)
		{
		 // System.out.println("Leaving with Horozontial win");
		  return isBingoH; 
		}	
  	}
//sums up vertical rows	
	
	for (int c=0; c<ROW; c++)
	{
		int sum1=0;
		for (int r=0; r<COL; r++)
		{
		  sum1=sum1+card1[r][c];  		 
		}
	  if (sum1==0)
		{
		 // System.out.println("Leaving with Vertical Win");
		  return isBingoR;
		}
 	} 

//sum up diagonal 
	
	int sum2=0;
	for (int r=0; r<ROW; r++)
	 {
	 	sum2=sum2+card1[r][r];	
	 }
	
	 int sum3=0;
	 for (int r=0; r<ROW; r++)
	 {
		sum3=sum3+ card1[r][ROW-r-1];
	 }

  	
	if (sum2 ==0)
	{
	 //System.out.println("Leaving with Diagonal win"); 
	 return isBingoD;	
	}
	else if (sum3==0)
	{
	 // System.out.println("Leaving with Diagonal win");
	  return isBingoD;
	}
	else
	 // System.out.println("Leaving with no win");  
	  return isNotBingo;
 
 }

    
 }
