package Reflections.reflectclass;

public class Bird {
	private String name;
	private int age;
	
	public Bird(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Bird() {}

	public void fly(int speed)
	{
		System.out.println(this.name + " flies in " + speed + " km per hour");
	}
	
	private void layEggs(int eggs)
	{
		System.out.println(this.name + " lays " + eggs + " eggs at " + this.age + " years old");
	}

}
