package singleton.lazyinitialisation;

public class DBConnection {

	private static DBConnection conObj;
	
	private DBConnection() {}
	
	public static DBConnection getInstance()
	{
		if (conObj ==  null) {
			conObj = new DBConnection();
		}
		return conObj;
	}
}
