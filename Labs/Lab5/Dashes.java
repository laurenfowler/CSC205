
public class Dashes
{
	public static void main(String[] args)
	{
		String word = "Two-Thousand-And-Sixteen";
		System.out.println(removeDashes(word));
	}

	public static String removeDashes(String word)
	{		
		StringBuffer stringBuf= new StringBuffer();
		
		for (int i=0;i<word.length(); i++)
		{
			if (word.charAt(i) != '-')
			{
				stringBuf.append(word.charAt(i));
			}
			if (word.charAt(i) == '-')
			{
				stringBuf.append(' '); 
			}
		}		
  //toString(); converts stringBuf to a string
		return stringBuf.toString();
	}



}
