package Exception.Unchecked;

public class Unchecked {

	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		throw new ArithmeticException();
	}
}
