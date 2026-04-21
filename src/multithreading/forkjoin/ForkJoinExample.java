package multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinExample {

	public static void main(String[] args) {
		
		ForkJoinPool forkPool = ForkJoinPool.commonPool();
		Future<Integer> futureObj = forkPool.submit(new ComputeSumTask(0, 100));
		
		try {
			System.out.println(futureObj.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
