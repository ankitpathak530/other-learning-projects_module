package Blocking_Queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer() {
		// TODO Auto-generated constructor stub
	}
	public Producer(BlockingQueue<Message> queue) {
		   this.queue = queue;
		}
	
	@Override
	public void run() {
			for(int i=1; i<=20; i++) {
				try 
				{
					Message message;
					Thread.sleep(i);
					message = new Message("Message "+i);
	                queue.put(message);	
	                System.out.println("Message Produced: "+message.getMessage());
			    }
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			

			
			
			Message message = new Message("EXIT");
			try {
				queue.put(message);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}		
	}

}