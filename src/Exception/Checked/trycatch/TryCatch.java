package Exception.Checked.trycatch;

public class TryCatch {

	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		
		try {
			throw new ClassNotFoundException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			System.err.println("Inside finally block");
		}
	}
}
