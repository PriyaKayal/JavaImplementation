package com.oops;
/**
 * @author Gnanapriya
 * 		   This class is used for example of this keyword 
 *         Invoking current class constructor
 *         Refering current class instance variable
 *         "this" can be passed as argument in the constructor call.
 */
public class Person {
	String name;
	int age;
	String nickName;
	String companyName;

	public Person(String name, int age, String nickName) {
		this.name = name;
		this.age = age;
		this.nickName = nickName;
	}

	public Person(String name, int age, String nickName, String companyName) {
		this(name, age, nickName);
		this.companyName = companyName;
	}

	@Override
	public String toString() {
//		return super.toString();
		return "Name = " + this.name + ", Nick Name = " + this.nickName + ", Company Name = " + this.companyName;
	}

	public static void main(String[] args) {
		Person personObj = new Person("priya", 23, "Kayal");
		System.out.println(personObj);
		personObj = new Person("Soniya", 16, "Soni", "Accolite");
		System.out.println(personObj);
	}
}

/*
 * Output: Name = priya, Nick Name = Kayal, Company Name = null Name = Soniya,
 * Nick Name = Soni, Company Name = Accolite
 */