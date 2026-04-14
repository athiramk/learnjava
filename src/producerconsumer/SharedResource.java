package producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedResource {
	Queue<Integer> buffer = new ArrayDeque<>(5);
	static int count = 1;
	
	public synchronized void produce()
	{		
		System.out.println("Buffer size in produce :" + buffer.size());
		while(buffer.size() == 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("producing :" + count);
		buffer.add(count);
		count++;
		System.out.println("Buffer size in produce :" + buffer.size());
		notify();
	
	}
	
	public synchronized void consume() {
		
		System.out.println("Buffer size in consume :" + buffer.size());
		
		while(buffer.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		System.out.println("Consuming :" + buffer.remove());
		System.out.println("Buffer size in consume :" + buffer.size());
		notify();
		
	}

}
