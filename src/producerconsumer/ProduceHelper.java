package producerconsumer;

public class ProduceHelper implements Runnable{

	SharedResource r;
	
	
	public ProduceHelper(SharedResource r) {
		super();
		this.r = r;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.produce();
		}
	}

}
