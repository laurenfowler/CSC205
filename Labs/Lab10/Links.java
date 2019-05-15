
public class Links
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(11));
   		pos1.setNext(new Node(new Integer (15), null));
    		pos2 = new Node(new Integer(13), null);
		pos2.setNext(pos1);
		printList(pos2);
		System.out.println(count(pos2));
		Node max= findMax(pos1);
		System.out.println(max.getItem());		
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}
//need head.getNext() to move to next node
	private static int count(Node head)
	{
		if (head.getNext()==null)
		{
			return 0;
		}
		else 
			return 1 + count(head.getNext());
	}

	private static Node findMax(Node head) 
	{
		Node max=head;
		Node curr=head;
		while (curr.getItem() !=null)
		{
			if( ((Comparable) max.getItem()).compareTo(curr.getItem()) < 0)
			{
				max=curr;

			}
			if(curr.getNext()!=null)
			{
				curr=curr.getNext();
			}			
			else break;			
		
		}	

		return max;
}
}
