package multithreading.readwritelock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		try {
			
			lock.readLock().lock();
			System.out.println("Read lock acquired by :  " + Thread.currentThread().getName());
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Read lock released by :  " + Thread.currentThread().getName());
			lock.readLock().unlock();
			
		}
		
	}
	
	public void update() {
		
		try {
			lock.writeLock().lock();
			System.out.println("Write lock acquired by :  " + Thread.currentThread().getName());
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			System.out.println("Write lock released by :  " + Thread.currentThread().getName());
			lock.writeLock().unlock();
			
			
		}
	}
	
}
