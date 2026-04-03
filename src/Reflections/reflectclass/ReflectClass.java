package Reflections.reflectclass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		String myClass = "Bird";
		//Class birdClass = Class.forName(myClass);
		//Class birdClass = Bird.class;
		Class birdClass = Class.forName("Reflections.reflectclass.Bird");
		
		
		
		Method[] methods = birdClass.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println(method.getName());
			System.out.println(Modifier.toString(method.getModifiers()));
			System.out.println(method.getParameterTypes()[0]);
			System.out.println(method.getReturnType());
			
		}		
		
		Object xObject = birdClass.newInstance();
		Method flyMethod = birdClass.getMethod("fly", int.class);
		flyMethod.invoke(xObject, 5);
	}

}
