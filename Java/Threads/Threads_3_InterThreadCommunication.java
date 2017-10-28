import java.util.Scanner;
class ThreadCreator
{
	void method1() throws InterruptedException
	{
		synchronized(this)
		{
			System.out.println("Method 1 started.");
			System.out.println("Method 1 going to wait.");
			wait();
			System.out.println("Method 1 restarted.");
			System.out.println("Method 1 going to end.");
		}
	}
	void method2() throws InterruptedException
	{
		Scanner s1 = new Scanner(System.in);
		Thread.sleep(1000);//To make sure method1() runs first.
		synchronized(this)
		{
			System.out.println("Method 2 started.");
			System.out.println("Method 2 waiting for return key.");
			s1.nextLine();
			System.out.println("Method 2 received the signal for return key.");
			System.out.println("Method 2 calling notify.");
			notify();
			System.out.println("Method 2 going to sleep for 2 seconds.");
			Thread.sleep(2000);
			System.out.println("Method 2 ending.");			
		}
	}
}

class Threads_3_InterThreadCommunication
{
	public static void main(String args[])
	{
		ThreadCreator tc = new ThreadCreator();
		try
		{
			Thread t1 = new Thread(
				new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							tc.method1();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			);
			Thread t2 = new Thread(
				new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							tc.method2();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			);
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
