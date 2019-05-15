
public class Pez
{
	public static void main(String []args) throws CloneNotSupportedException
	{
		Stack pez=new Stack();
		populateStack(pez);
		pez=(Stack) removeGreen(pez);
		printPez(pez);
	}

	

	public static void  populateStack(Stack pez)
	{
		pez.push("yellow");
		pez.push("red");
		pez.push("green");
		pez.push("green");
		pez.push("yellow");
		pez.push("yellow");
		pez.push("red");
		pez.push("green");

	}

	public static Stack removeGreen(Stack pez) 
	{
		Stack tempPez= new Stack();			
		while(!pez.isEmpty())	
		{	
			if(pez.top().equals("green"))
			{
				pez.pop();	
			}
			else 
				tempPez.push(pez.pop());	
				
		}
		

		while(!tempPez.isEmpty())
		{
			pez.push(tempPez.pop());
		}		
		
		return pez;
	
	}

	public static void printPez(Stack pez) throws CloneNotSupportedException
	{
		Stack tempPez=(Stack) pez.clone();
		while(!tempPez.isEmpty())
		{
			System.out.println(tempPez.pop());		
		}	
	}
	
	}

