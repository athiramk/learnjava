package multithreading.reentrantlock;

public class Main {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		
		Thread t1 = new Thread(() -> {
			account.withdraw(1000);
		});
		
		Thread t2 = new Thread(() -> {
			account.withdraw(100);
		});
		
		t1.start();
		t2.start();

	}

}
