package multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableMain {
	public static void main(String[] args) {
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1,TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		
		Future<?> futureObj = poolExecutor.submit(() -> {
			System.out.println("This is the task with Runnable");
		});
		
		
		try {
			Object obj = futureObj.get();
			System.out.println(obj==null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		List<Integer> res = new ArrayList<>();
		
		Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
			System.out.println("This is the task with Runnable and return object");
			res.add(10);
			}, res);
		
		
		try {
			List<Integer> outputres = futureObj3.get();
			System.out.println(outputres.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
			System.out.println("This is the task with Callable");
			List<Integer> output = new ArrayList<>();
			output.add(300);
			return output;
		});
		
		try {
			List<Integer> outputresult = futureObj2.get();
			System.out.println(outputresult.get(0));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		poolExecutor.shutdown();
		
	}

}
