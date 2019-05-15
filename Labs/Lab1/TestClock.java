import java.util.*;

public class TestClock{

	public static void main (String[] args) {
		
		Clock dvr=new Clock();

		System.out.println("What time would you like to set the DVR to?");
		Scanner in=new Scanner(System.in);
		
		System.out.println ("Hour:");
		int hour=in.nextInt();
		System.out.println ( "Minute:");
		int minute=in.nextInt();
		System.out.println("Second:");
		int second=in.nextInt();
		
		dvr.reset(hour, minute, second);
		System.out.println("The current time is:" + dvr);
		dvr.advance();
		System.out.println("The advanced time is:" + dvr);
	}	
}
