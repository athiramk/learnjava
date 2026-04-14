package FunctionalInterface.normalway;

public class Eagle implements Bird{

	@Override
	public void fly(String name) {
		System.out.println(name + "flies");
	}

}
