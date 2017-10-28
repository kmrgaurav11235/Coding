import java.util.Random;
class Queue
{
	private final int MAX_SIZE = 3;
	
	private int a[] = new int[MAX_SIZE];
	private int front;
	private int back;
	
	Queue()
	{
		front = -1;
		back = -1;
	}
	
	boolean isEmpty()
	{
		if(front == -1 && back == -1)
			return true;
		return false;
	}
	
	boolean isFull()
	{
		if(front == ((back + 1) % MAX_SIZE))
			return true;
		return false;
	}
	
	boolean enQueue(int info)
	{
		if(isFull())
			return false;
		back = (back + 1) % MAX_SIZE;
		a[back] = info;
		if(front == -1)
			front = 0;
		return true;
	}
	
	int deQueue()
	{
		int info;
		if(isEmpty())
			return 0;
		info = a[front];
		if(front == back)
		{
			front = -1;
			back = -1;
		}
		else
			front = (front + 1) % MAX_SIZE;
		return info;
	}
}

class ProducerConsumer
{
	void producer(Queue q) throws InterruptedException
	{
		Random r = new Random();
		while(true)
		{
			synchronized(this)
			{
				while(q.isFull())
				{
					System.out.println("Queue is Full. Producer is going to wait.");
					wait();
				}
				int info = r.nextInt(101);//Produce int between 0 and 100
				System.out.println("Producer has produced integer " + info + ". Inserting it to Queue.");
				q.enQueue(info);
				System.out.println("Producer has inserted " + info + " to Queue. Calling notify()");
				notify();
				
				Thread.sleep(2000);//This line makes the process slow so that we compherend it better.
			}
		}
	}
	
	void consumer(Queue q) throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				while(q.isEmpty())
				{
					System.out.println("Queue is Empty. Consumer is going to wait.");
					wait();
				}
				int info = q.deQueue();
				System.out.println("Consumer is consuming integer " + info + ".");
				System.out.println("Consumer Calling notify()");
				notify();
				
				Thread.sleep(2000);//This line makes the process slow so that we compherend it better.
			}
		}
	}
}

class Threads_4_ProducerConsumer
{
	public static void main(String args[])
	{
		Queue q = new Queue();
		ProducerConsumer pc = new ProducerConsumer();
		
		try
		{
			Thread prod = new Thread(
				new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							pc.producer(q);
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			);
			
			Thread con = new Thread(
				new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							pc.consumer(q);
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			);
			
			prod.start();
			con.start();
			
			prod.join();
			con.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
