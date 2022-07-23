package Java8.model;

import java.util.List;

public class Person {

	private String name;
	private int height;
	private double age;
    private List<Hobbies> hobbies;	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Hobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public Person(String name, int height, double age, List<Hobbies> hobbies) {
		super();
		this.name = name;
		this.height = height;
		this.age = age;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", age=" + age + ", hobbies=" + hobbies + "]";
	}

	
}
