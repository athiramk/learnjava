package multithreading.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
	StampedLock lock = new StampedLock();
	
	public void write()
	{
		long stamp = lock.writeLock();
		try {
			
			System.out.println("Write lock acquired by : " + Thread.currentThread().getName());
			
		} finally {
			System.out.println("Write lock released by : " + Thread.currentThread().getName());
			lock.unlockWrite(stamp);

		}
	}
	
	public void optimisticRead() {
		
		long stamp = lock.tryOptimisticRead();
		System.out.println("Optimistic read stamp : " + stamp + " " + Thread.currentThread().getName());
		
		try {
			//Thread.sleep(2000);
			if(lock.validate(stamp))
				System.out.println("Stamp validated - no write occured in between - valid data " + Thread.currentThread().getName());
			else
				System.out.println("Invalid stamp - have to rollback " + Thread.currentThread().getName());
			
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public void pessimisticRead() {
		
		long stamp = lock.readLock();
		
		try {
			System.out.println("Read lock acquired - Blocks the writers " + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Read lock released " + Thread.currentThread().getName());
			lock.unlock(stamp);
		}
		
	}

}
