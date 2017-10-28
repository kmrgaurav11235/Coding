import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Comparision between ArrayList and LinkedList:-

    Insertions are easy and fast in LinkedList as compared to ArrayList because there is no
    risk of resizing array and copying content to new array if array gets full which makes
    adding into ArrayList of O(n) in worst case, while adding is O(1) operation in LinkedList
    in Java. ArrayList also needs to be update its index if you insert something anywhere except
    at the end of array.
    Removal also better in LinkedList than ArrayList due to same reasons as insertion.
    LinkedList has more memory overhead than ArrayList because in ArrayList each index only
    holds actual object (data) but in case of LinkedList each node holds both data and address
    of next and previous node.
    Both LinkedList and ArrayList require O(n) time to find if an element is present or not. However we can do Binary Search on ArrayList if it is sorted and therefore can search in O(Log n) time.
 * 
 */

class Collections_6_ArrayListNLinkedList
{
	public static void main(String args[])
	{
		ArrayList<String> al = new ArrayList<>();
		al.add("Brother o' Brother");
		al.add("my");
		al.add("days");
		al.add("here");
		al.add("are");
		al.add("done,");
		al.add("the");
		al.add("dornishman's");
		al.add("taken");
		al.add("my");
		al.add("life!");
		System.out.println("ArrayList: " + al);
		System.out.println("ArrayList size: " + al.size());
		
		LinkedList<String> ll = new LinkedList<>();
		ll.add("But");
		ll.add("why");
		ll.add("does it");
		ll.add("matters,");
		ll.add("for");
		ll.add("all");
		ll.add("men");
		ll.add("must");
		ll.add("die,");
		ll.add("and");
		ll.add("I've");
		ll.add("tasted");
		ll.add("the");
		ll.add("dornishmen's");
		ll.add("wife.");
		System.out.println("\nLinkedList: " + ll);
		System.out.println("LinkedList size: " + ll.size());
		
		System.out.println("\nElement at index 5 from ArrayList: " + al.get(5));
		System.out.println("\nElement at index 5 from LinkedList: " + ll.get(5));
		
		System.out.println("\nRemoving element at index 3 from ArrayList.");
		al.remove(3);
		System.out.println("ArrayList: " + al);
		
		System.out.println("\nRemoving element at index 3 from LinkedList.");
		ll.remove(3);
		System.out.println("LinkedList: " + ll);
		
		System.out.println("\nRemoving element 'taken' from ArrayList.");
		al.remove("taken");
		System.out.println("ArrayList: " + al);
		
		System.out.println("\nRemoving element 'why' from LinkedList.");
		ll.remove("why");
		System.out.println("LinkedList: " + ll);
	}
}
