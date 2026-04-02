package immutable.immutableclass;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Object> petname = new ArrayList<>();
		petname.add("lucy");
		petname.add("nachos");
		
		ImmutableClass immutableObj = new ImmutableClass("augusta", petname);
		immutableObj.getObjList().add("bacardi");
		
		System.out.println(immutableObj.getObjList());
	}

}
