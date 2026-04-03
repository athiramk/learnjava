package Reflections.reflectconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectConstructor {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class birdClass = Bird.class;
		
		Constructor[] constructors = birdClass.getDeclaredConstructors();
		
		for(Constructor constructor: constructors) {
			System.out.println(Modifier.toString(constructor.getModifiers()));
			
			constructor.setAccessible(true);
			
			Bird birdObj = (Bird) constructor.newInstance();

			birdObj.fly();
		}
	
	}

}
