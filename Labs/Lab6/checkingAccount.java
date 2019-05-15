public class checkingAccount extends Account
{
  private int numChecks;
  public double checkAmount;

  public checkingAccount(double initBalance)
  {
	super(initBalance);
	numChecks=0;
  }

  public int getChecksWritten()
  {
	return numChecks; 
  }

  public void writeCheck(double checkAmount)
  {
	numChecks++;
	withdraw(checkAmount); 	
  	
  }




}
