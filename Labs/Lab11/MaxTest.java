
import java.io.*;

public class MaxTest 
{
   public static void main(String[] args) throws IOException, CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push("Andy");
		stack1.push("Allison");
		stack1.push("Aaron");
		stack1.push("Austin");
		stack1.push("Abbey");
		stack1.push("Alex");
        	System.out.println("findMax(stack1)="+findMax(stack1)); 
        	System.out.println("stack1.findMax()="+stack1.findMax()); 
  }

  public static String findMax (Stack stack1) throws CloneNotSupportedException
  {
	Stack tempStack= (Stack) stack1.clone();
	String max= (String) tempStack.top();
	//this next line destroys the current copy of the current max
	tempStack.pop();
	while(!tempStack.isEmpty())
	{
		String curr= (String) tempStack.top();
		if(curr.compareTo(max) > 0)
			max= curr;
		tempStack.pop();	
	}
	
	return max; 
  }

}
