package multithreading.readwritelock;

public class Main {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
		Thread t1 =  new Thread(() -> {
			resource.read();
		});
		Thread t2 =  new Thread(() -> {
			resource.read();
		});
		Thread t3 =  new Thread(() -> {
			resource.update();
		});
		Thread t4 =  new Thread(() -> {
			resource.read();
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
