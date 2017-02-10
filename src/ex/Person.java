package ex;

public class Person {
	private String name;
	private int age;
	//无参构造器
	public Person(){}
	//初始化全部属性的构造器
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//getter和setter方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
