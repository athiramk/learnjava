package multithreading.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadPoolExecutor poolExcecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), 
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		
		
		Future<?> futureObj = poolExcecutor.submit(() -> {
			System.out.println("this is the task which the thread will execute");
		});
		
		System.out.println(futureObj.isDone());
		
		try {
			futureObj.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(futureObj.isDone());
		System.out.println(futureObj.isCancelled());
	}

}
