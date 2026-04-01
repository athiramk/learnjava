package singleton.synchronised;

public class DBConnection2 {
	private static volatile DBConnection2 conObj;
	
	private DBConnection2() {}
	
	public static DBConnection2 getInstance() {
		
		if(conObj == null)
		{
			synchronized (DBConnection2.class) {
				if(conObj == null) {
					conObj = new DBConnection2();
				}	
			}
		}
		return conObj;		
		
	}

}
