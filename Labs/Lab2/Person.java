public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;
  private String defaultname= "N/A";

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }

  //default construtor
  public Person()
 {
 	name= defaultname;
	personCount++;
	id= -1; 
 }

  public void reset(String name, int id)
  {
	this.name=name;
	this.id=id;
  }

  public String getName()
  {
	return name;
  } 

  public int  getId()
  {
	return id; 
  }

  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }
  
}
