package singleton.synchronised;

public class DBConnectionBillPugh {
	
	private DBConnectionBillPugh() {}
	
	private static class DBConnectionHelper {
		private static final DBConnectionBillPugh CON_OBJ = new DBConnectionBillPugh();
	}

	public static DBConnectionBillPugh getInstance() {
		return DBConnectionHelper.CON_OBJ;
	}
	
}
