package multithreading.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),new CustomeRejectedHandler());
		
		for( int i = 0; i < 7; i++) {
			poolExecutor.submit(() -> {
				try {
					Thread.sleep(5000);
					
				} catch (Exception e) {
					
				}
				System.out.println("task processed :" + Thread.currentThread().getName());
			});
		}
		poolExecutor.shutdown();

	}

}

class CustomeRejectedHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		
		System.out.println("task denied :" + r.toString());
		
	}
	
}

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r);
		return th;
	}
	
}