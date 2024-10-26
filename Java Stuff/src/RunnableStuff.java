
public class RunnableStuff {
	
	public static void main(String...args)
	{
		doStuff();
	}
	
	public static void doStuff()
	{
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run()
			{
				while(System.currentTimeMillis()<1000000000) System.out.println(1);
					
			}
		});
		thread.start();
	}
}
