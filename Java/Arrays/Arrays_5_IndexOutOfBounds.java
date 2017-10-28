import java.util.ArrayList;
class Arrays_5_IndexOutOfBounds
{
	public static void main(String args[])
	{
		ArrayList <String> list = new ArrayList<>();
		list.add("Laugh it up Fuzzball!!");
		list.add("Never tell me the odds.");
		list.add("Some rescue you are!");
		try
		{
			System.out.println(list.get(0));
			System.out.println(list.get(1));
			System.out.println(list.get(2));
			System.out.println(list.get(3));
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Error: Array Index went out of Bounds.");
		}
	}
}
