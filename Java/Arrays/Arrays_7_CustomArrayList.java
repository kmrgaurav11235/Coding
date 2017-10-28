import java.util.ArrayList;
/*
 * A custom arraylist has attributes based on user requirements and can have more than one type of data. This data is provided 
 * by a custom inner class which is formed by combination of various primitive object datatypes.
 */
class StudentArrayList
{
	class Student
	{
		private int rollNum;
		private String name;
		private int totalMarks;
		private long phoneNum;
		
		Student(int rollNum, String name, int totalMarks, long phoneNum)
		{
			this.rollNum = rollNum;
			this.name = name;
			this.totalMarks = totalMarks;
			this.phoneNum = phoneNum;
		}
		String getStudentDetails()
		{
			return ("Roll Num: " + rollNum + "\nName: " + name + "\nTotal Marks: " 
				+ totalMarks + "\nPhone Number: " + phoneNum + "\n");
		}
	}
	//end of Student
	
	private ArrayList<Student> studentList = new ArrayList<>();
	
	void addInfo(int rollNum, String name, int totalMarks, long phoneNum)
	{
		Student s = new Student(rollNum, name, totalMarks, phoneNum);
		studentList.add(s);
	}
	void printInfo()
	{
		for(Student s: studentList)
		{
			System.out.println(s.getStudentDetails());
		}
	}
}

class Arrays_7_CustomArrayList
{
	public static void main(String args[])
	{
		StudentArrayList s = new StudentArrayList();
		s.addInfo(142, "Luke", 86, 66677788L);
		s.addInfo(143, "Leigh", 91, 62675788L);
		s.addInfo(144, "Anakin", 97, 66697788L);
		s.addInfo(145, "Hans", 76, 66617788L);
		s.addInfo(146, "Lando", 76, 66611788L);
		s.addInfo(147, "Padmae", 95, 66677228L);
		
		s.printInfo();
	}
}
