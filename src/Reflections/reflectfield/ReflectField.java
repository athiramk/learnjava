package Reflections.reflectfield;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectField {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class birdClass = Bird.class;
		
		Field[] fields = birdClass.getDeclaredFields();
		Bird bObj = new Bird();
		//bObj.name = "pam";
		for(Field field : fields) {
			System.out.println(field.getName());
			System.out.println(Modifier.toString(field.getModifiers()));
		}
		Field pubFieldName = birdClass.getDeclaredField("name");
		pubFieldName.set(bObj, "pam");
		
		System.out.println(bObj.name);
		
		
		Field privFieldName = birdClass.getDeclaredField("age");
		privFieldName.setAccessible(true);
		privFieldName.set(bObj, 5);
		
		bObj.layEggs(3);

	}

}
