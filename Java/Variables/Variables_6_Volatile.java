class SharedClass
{
	/*
	Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread safe. Thread safe means that a 
	method or class instance can be used by multiple threads at the same time without any problem.
	 */
	static int threadUnsafe;
	/*
	Suppose that two threads are working on SharedClass. If two threads run on different processors each thread may have its own 
	local copy of threadUnsafe variable. If one thread modifies its value the change might not reflect in the original one in the 
	main memory instantly. This depends on the write policy of cache. Now the other thread is not aware of the modified value which 
	leads to data inconsistency. 
	 */
	
	static volatile threadSafe;
	/*
	For Java, "volatile" tells the compiler that the value of a variable must never be cached as its value may change outside 
	of the scope of the program itself.
	 */
	 
	 /*
	 volatile vs synchronized:
	 Two important features of locks and synchronization:
		-> Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
		-> Visibility: It means that changes made by one thread to shared data are visible to other threads.
	
	 Java’s synchronized keyword guarantees both mutual exclusion and visibility. If we make the blocks of threads that modifies the 
	 value of shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the 
	 main memory. All other thread trying to enter the block at the same time will be blocked and put to sleep.

	 In some cases we may only desire the visibility and not atomicity. Use of synchronized in such situation is an overkill and 
	 may cause scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized 
	 but not the atomicity features. The values of volatile variable will never be cached and all writes and reads will be done to 
	 and from the main memory. However, use of volatile is limited to very restricted set of cases as most of the times atomicity
	 is desired. For example a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is 
	 really a compound read-modify-write sequence of operations that must execute atomically.
	  */
	}
class Variables_6_Volatile
{
	public static void main(String args[])
	{
		
	}
}
