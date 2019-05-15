import java.util.*;

public class words
{
	public static void main (String [] args)
	{

	Scanner input=new Scanner(System.in);
	String word= input.next();
	
	for (int i=word.length(); i>0; i--)
	{
		System.out.println(word.substring(0, i));	
	}

	}


}
