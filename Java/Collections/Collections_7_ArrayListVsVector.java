import java.util.ArrayList;
import java.util.Vector;
/*
 * Differences between ArrayList and Vector:

    Synchronization : Vector is synchronized that means at a time only one thread can access the code while arrayList is not synchronized 
    that means multiple threads can work on arrayList at same time. For example, if one thread is performing add operation, then there 
    can be another thread performing remove operation in multithreading environment. If multiple threads access arrayList concurrently,
    then we must synchronize the block of the code which modifies the list either structurally or simple modifies element. 
    Structural modification means addition or deletion of element(s) from the list. Setting the value of an existing element is not 
    a structural modification.
    
    Performance: ArrayList is faster as it is non-synchronized while vector operations give slow performance as they are synchronized
    (thread-safe). If one thread works on vector has acquired lock on it which makes other thread will has to wait till lock is released.
    
    Data Growth: ArrayList and Vector both grow and shrink dynamically to maintain optimal use of storage. But the way they resized 
    is different. ArrayList increments 50% of current array size if number of elements exceeds its capacity while vector increments 
    100% means doubles the current array size.
    
    Traversal: Vector can use both Enumeration and Iterator for traversing over elements of vector while ArrayList can only use 
    Iterator for traversing. 
 */
class Collections_7_ArrayListVsVector
{
	public static void main(String args[])
	{		
		Vector<String> v = new Vector<>();
		v.addElement("Surge");
		v.addElement("upon");
		v.addElement("the");
		v.addElement("seas.");
		
		ArrayList<String> al = new ArrayList<>();
		al.add("And");
		al.add("rage");
		al.add("upon");
		al.add("the");
		al.add("skies.");
		
		System.out.println("Vector: " + v);
		System.out.println("ArrayList: " + al);
		
		System.out.println("\nVectors are thread-safe. So, they are slower.");
		System.out.println("ArrayLists are not thread-safe. So, they are faster.");
	}
}
