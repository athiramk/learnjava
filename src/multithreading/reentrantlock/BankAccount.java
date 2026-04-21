package multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(double amount) {
        lock.lock(); // (1) Thread acquires lock (count = 1)
        try {
        	
        	Thread.sleep(2000);
            // Perform withdrawal logic...
            
            // Now call another method that also needs the lock
            logTransaction("Withdrawal of " + amount); 
        } catch(InterruptedException e) {
        	
        } finally {
            lock.unlock(); // (4) Lock count becomes 0, released for others
        }
    }

    private void logTransaction(String message) {
        lock.lock(); // (2) SUCCESS! Because it's reentrant, the thread 
                     // doesn't block; it just increments count to 2.
        try {
            System.out.println(message);
        } finally {
            lock.unlock(); // (3) Lock count goes back to 1
        }
    }
}
