public class Baby
{
	//tests Queue class and makes sure it works
	public static void main (String []args)
	{
	Queue test=new Queue();
	test.enqueue("David");
	test.enqueue("Lauren");
	test.enqueue("Blake");
	test.enqueue("Mary");
	test.enqueue("Leon");
	test.enqueue("Mason");
	//test.dequeue();
	
	System.out.println(test.front());
	test.dequeue();
	System.out.println(test.front());
		
	}



}
