import java.util.*;
import java.io.*;
import java.io.IOException;
import java.text.DecimalFormat;
public class TimeShare
{
	public static void main (String [] args) throws CloneNotSupportedException, FileNotFoundException
	{
		//initalizes new Queue and reads in jobs from command line file
		Queue arrival=fileReader(args);	
		Queue output= new Queue();
		//num[0] is usageTime  num[1] is idle time 
		int [] nums=new int[2];	
	        processJob(arrival, output, nums);		
		printReport(output, nums);
	
	}

	//reads in job file and inserts new jobs in arrival queue, and then returns the queue
	public static Queue fileReader(String [] args) throws FileNotFoundException
	{
	
	  Queue arrival = new Queue();  
	
	  try
	  {
	    String input = args[0];
	    Scanner in = new Scanner(new File(input));
	  
	  	while(in.hasNext())
		{
			arrival.enqueue(new Job(in.next(), in.nextInt(), in.nextInt()));
		}
	  }
	 
	  catch(IOException e)
	  {
	  System.out.println(e.getMessage());
	  }
	
	return arrival;
	}
	//end queue
	
	public static void processJob(Queue arrival, Queue output, int[]nums) 
	{
		int clockTime=1;
		int idleTime=0;
		int usageTime=0;
		
		Queue jobQueue = new Queue(); 

		while(!arrival.isEmpty() || !jobQueue.isEmpty())
		{

			if(!arrival.isEmpty())
			{
				checkRecord(arrival, jobQueue, clockTime); 										}	
				
			if(!jobQueue.isEmpty())
			{
				checkJobRecord(jobQueue, output, clockTime);
								
			}
		
			if(!jobQueue.isEmpty())
			{
				checkJobRecord(jobQueue, output, clockTime);				
			}

			if(jobQueue.isEmpty() && !arrival.isEmpty())
			{
				idleTime++;
			}	
			if(!jobQueue.isEmpty())		
			{
				usageTime++;
			}
			
			clockTime++;
		}

		nums[0]=usageTime;
		nums[1]=idleTime;
		

	
	}	

	public static void checkRecord(Queue arrival, Queue jobQueue, int clockTime)
	{
		Job job = (Job) arrival.front();
		if (job.arrivalTime == clockTime)
		{
			jobQueue.enqueue(job);
			arrival.dequeue(); 		
		}
	}

	public static void checkJobRecord(Queue jobQueue, Queue output, int clockTime)
	{
		Job job =(Job) jobQueue.front();
		if(job.startTime != -1 && job.runTime== clockTime-job.startTime)
		{
			output.enqueue(jobQueue.dequeue());
			job.turnTime=job.runTime+job.waitTime;
		}
	
		if(job.startTime==-1 && job.arrivalTime <= clockTime)
		{
			job.startTime=clockTime;
			job.waitTime=clockTime-job.arrivalTime;
		}
	}

	public static void printReport(Queue output, int[] nums) throws CloneNotSupportedException
	{
		//need to use clone method
		Queue clone= (Queue) output.clone();
		Queue clone2= (Queue) output.clone();
		
		double waitTotal=0;
		double jobTotal=0;
		while(!clone2.isEmpty())
		{
			jobTotal++;
			Job job=(Job) clone2.front();
			waitTotal=waitTotal+job.waitTime;
			clone2.dequeue();
		}

		//System.out.println("Wait total = " + waitTotal);
		//System.out.println("job total = " + jobTotal);

		System.out.println("     Job Control Analysis : Summary Report");
		System.out.println("-----------------------------------------------");
		System.out.println("job id  arrival  start  run   wait  turnaround ");
		System.out.println("         time    time   time  time  time       ");
		System.out.println("-----   ------   -----  ----  ----  ---------- ");
		while(!clone.isEmpty())
		{
			System.out.println(clone.dequeue());
		}
		
		double usage= (double) nums[0];
		double idle= (double) nums[1];

		double cpuUse=(usage/(usage+ idle)*100);
		//DecimalFormat df=new DecimalFormat("##.##");
		//df.format(cpuUse);
			
		System.out.println("Average Wait Time => " + Math.round((waitTotal/jobTotal) * 100.00 )/100.00 );
		System.out.println("CPU Usage => " + nums[0]);
		System.out.println("CPU Idle => " + nums[1]);
		System.out.print("CPU Usage =>"); 
		System.out.printf("%1.2f" , cpuUse);
		System.out.print("%");
		


	
	}	

	 
}
