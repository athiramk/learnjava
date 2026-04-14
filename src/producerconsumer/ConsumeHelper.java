package producerconsumer;

public class ConsumeHelper implements Runnable{

	SharedResource r;
	
	public ConsumeHelper(SharedResource r) {
		super();
		this.r = r;
	}
	
	@Override
	public void run() {

		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.consume();
		}
	}
	

}
