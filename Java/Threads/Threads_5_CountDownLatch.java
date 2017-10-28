import java.util.concurrent.CountDownLatch;
class Worker extends Thread
{
	private int waitInMs;
	private CountDownLatch l;
	Worker(String name, int waitInMs, CountDownLatch l)
	{
		super(name);
		this.waitInMs = waitInMs;
		this.l = l;
	}
	
	@Override
	public void run()
	{
		String threadName = Thread.currentThread().getName();
		System.out.println("Starting thread " + threadName + ".");
		System.out.println(threadName + " is calling countDown() and going to sleep.");
		l.countDown();
		try
		{
			Thread.sleep(waitInMs);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(threadName + " is going to end.");
		
	}
}
class Threads_5_CountDownLatch
{
	public static void main(String args[])
	{
		CountDownLatch c = new CountDownLatch(4);
		Worker w1 = new Worker("Worker1", 2000, c);
		Worker w2 = new Worker("Worker2", 2000, c);
		Worker w3 = new Worker("Worker3", 2000, c);
		Worker w4 = new Worker("Worker4", 2000, c);
		
		w1.start();
		w2.start();
		w3.start();
		w4.start();
		
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " is going to call await(). It will get blocked until CountDownLatch is released.");
		try
		{
			c.await();
			System.out.println("CountDownLatch is released. " + threadName + " is going to sleep.");
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(threadName + " is going to end.");
	}
}
