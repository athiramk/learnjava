package immutable.immutableclass;

import java.util.ArrayList;
import java.util.List;

final class ImmutableClass {
	private final String name;
	private final List<Object> objList;
	
	public ImmutableClass(String name, List<Object> objList) {
		this.name = name;
		this.objList = objList;
	}

	public String getName() {
		return name;
	}

	public List<Object> getObjList() {
		return new ArrayList<>(objList);
	}
	
}
