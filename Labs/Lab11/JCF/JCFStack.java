import java.util.*;

public class JCFStack
{
   public static void main(String[] args) throws CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push(new Integer(27));
		stack1.push(new Integer(0));
		stack1.push(new Integer(-3));
		stack1.push(new Integer(-18));
		stack1.push(new Integer(99));
		Object key=promptUser();
        	printStack (stack1); 
		System.out.println("Key value is " + (Integer) key);
		if(stack1.search(key) == -1)
		{
			System.out.println("Key was not found");
		}
		else
			System.out.println("Key value found at position " + stack1.search(key));
		

  }

  private static void printStack (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("*** Printing Out Stack:  ");

        while (! tempStack.isEmpty())
        {
               System.out.println(tempStack.peek());
               tempStack.pop();
        }
  }

 private static Object promptUser()
 {
	Scanner input=new Scanner(System.in);
	System.out.println("Please enter the key you are searching for");
	
	Integer key=new Integer(input.nextInt());
	
	return key;
 }


}
