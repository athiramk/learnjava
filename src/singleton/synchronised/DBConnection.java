package singleton.synchronised;

public class DBConnection {
	private static DBConnection conObj;
	
	private DBConnection() {}
	
	synchronized public static DBConnection getInstance() {
		if (conObj == null) {
			conObj = new DBConnection();
		}
		return conObj;
	}
}
