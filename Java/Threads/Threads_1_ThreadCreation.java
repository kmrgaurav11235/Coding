class ThreadCreator1 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Thread id: " + Thread.currentThread().getId() + " is running. Created using extending Thread Class");
	}
}
class ThreadCreator2 implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("Thread id: " + Thread.currentThread().getId() + " is running. Created using implementing Runnable interface.");
	}
}

class Threads_1_ThreadCreation
{
	public static void main(String args[])
	{
		int count = 5;
		for(int i = 0; i < count; i++)
		{
			ThreadCreator1 t1 = new ThreadCreator1();
			t1.start();
			
			Thread t2 = new Thread(new ThreadCreator2());
			t2.start();
		}
	}
}
