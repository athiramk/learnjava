package FunctionalInterface.Lambda;

public class BirdMain {

	public static void main(String[] args) {
		Bird b = (String name) -> {
			System.out.println(name + " flies");
		};
		b.fly("eagle");
	}

}
