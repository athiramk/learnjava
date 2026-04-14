package FunctionalInterface.AnonymousClass;

public class BirdMain {

	public static void main(String[] args) {
		
		Bird bird = new Bird() {
			@Override
			public void fly(String name) {
				System.out.println(name + " flies");
			}
			
		};
	}



}
