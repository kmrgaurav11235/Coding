class ObjectCreationStudent
{
	private String name;
	private String rollNum;
	private int age;
	
	public ObjectCreationStudent()
	{
		name = "";
		rollNum = "";
		age = 0;
	}
	public ObjectCreationStudent(String name, String rollNum, int age)
	{
		this.name = name;
		this.rollNum = rollNum;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}	
	public String getRollNum()
	{
		return rollNum;
	}
	public void setRollNum(String rollNum)
	{
		this.rollNum = rollNum;
	}	
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String toString()
	{
		return ("Name = " + name + ", Roll Num = " + rollNum + ", Age = " + age + ".");
	}
}

class Basic_4_ObjectCreation
{
	public static void main(String args[])
	{
		ObjectCreationStudent obj1 = new ObjectCreationStudent("Ulquiorra Cifer", "4", 21);
		System.out.println("First Object created is: " + obj1.toString() + "\n");
		
		//Student obj2 = (ObjectCreationStudent)Class.forName("ObjectCreationStudent").newInstance();
		//System.out.println("Second Object created is: " + obj2.toString() + "\n");
		
		ObjectCreationStudent obj3 = new ObjectCreationStudent("Nnoitra Gilga", "5", 31);
		System.out.println("Third Object created is: " + obj3.toString() + "\n");
		//ObjectCreationStudent obj4 = (ObjectCreationStudent)obj3.clone();
		//System.out.println("Third Object is cloned : " + obj4.toString() + "\n");
	}
}
