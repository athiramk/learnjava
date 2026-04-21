package multithreading.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {

	int start;
	int end;
	
	static final int THRESHOLD = 4;
	
	ComputeSumTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		
		if(end-start <= THRESHOLD) {
			int sum = 0;
			for(int i = start; i <= end; i++) sum+=i;
			
			return sum;
		}
		
		int mid = (start + end) / 2;
		ComputeSumTask leftTask = new ComputeSumTask(start, mid);
		ComputeSumTask rightTask = new ComputeSumTask(mid+1, end);
		
		leftTask.fork();             // 1. Send one to the queue for others
		int rightSum = rightTask.compute(); // 2. Do the second one YOURSELF right now
		int leftSum = leftTask.join();      // 3. Wait for the first one to finish (if not already done)

		return leftSum + rightSum;
		
	}

}
