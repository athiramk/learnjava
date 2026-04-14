package producerconsumer;

public class Main {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
		/*
		 * Thread t1 = new Thread(() -> { resource.produce(); });
		 * 
		 * Thread t2 = new Thread(() -> { resource.consume(); });
		 */

		
		ProduceHelper p = new ProduceHelper(resource);
		ConsumeHelper c = new ConsumeHelper(resource);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
		
		
	}

}
