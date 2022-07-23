package Blocking_Queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;
	
	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	
	public Consumer(BlockingQueue<Message> queue) {
	   this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Message msg;
		    while((msg = queue.take()).getMessage() !="exit"){
		       	Thread.sleep(1000);
		    	 System.out.println("Consumed "+msg.getMessage());
			}
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}	
	}

}
