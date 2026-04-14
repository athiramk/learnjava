package Collections.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableFunc {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		
		// Using iterator
		Iterator<Integer> it = myList.iterator();
		
		while(it.hasNext()) {
			int val = it.next();
			System.out.println(val);
			if(val == 3)
				it.remove();
		}
		
		// using for each loop
		for(Integer elem : myList)
			System.out.println(elem);
		
		//using forEach() method
		myList.forEach((Integer val) -> System.out.println(val));
		
	}

}
