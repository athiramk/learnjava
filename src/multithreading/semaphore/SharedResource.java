package multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
	

	public void produce(Semaphore lock) {
		try {
			
			lock.acquire();
			System.out.println("Lock acquired by : " + Thread.currentThread().getName());
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Lock released by : " + Thread.currentThread().getName());
			lock.release();
			
		}
	}
	
}
