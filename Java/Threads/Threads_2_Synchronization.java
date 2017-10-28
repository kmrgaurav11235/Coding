class MessageSender
{
	//Instead of using synchronized in run(), we can also make this method synchronized
	//synchronized void sender(String str)
	void sender(String str)
	{
		//or wrap this whole thing in synchronized
		//synchronized(this){
		System.out.println("Started sending message: " + str);
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Finished sending message: " + str);		 
	}
}

class SenderClass extends Thread
{
	private String msg;
	private MessageSender msgSender;
	
	SenderClass(String m, MessageSender ms)
	{
		msg = m;
		msgSender = ms;
	}
	
	@Override
	public void run()
	{
		synchronized(msgSender)
		{
			msgSender.sender(msg);
		}
	}
}

class Threads_2_Synchronization
{
	public static void main(String args[])
	{
		MessageSender m1 = new MessageSender();
		SenderClass s1 = new SenderClass("How you doing?", m1);
		SenderClass s2 = new SenderClass("I am Joey Tribbiani.", m1);
		s1.start();
		s2.start();
	}
}
