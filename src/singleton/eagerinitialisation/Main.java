package singleton.eagerinitialisation;

public class Main {
	
	public static void main(String[] args) {

		DBConnection myobj = DBConnection.getInstance();
		System.out.print(myobj.getClass().getName());
	}
}
