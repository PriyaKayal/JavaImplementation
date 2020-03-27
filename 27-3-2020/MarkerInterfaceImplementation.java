package com.oops;

/**
 * @author Gnanapriya Arumugam
 * Examples of marker interface are Serializable, Clonnable and Remote interface
 */
import java.util.Scanner;

public class MarkerInterfaceImplementation implements Cloneable {
	int age;
	String name;

	public MarkerInterfaceImplementation(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public void display() {
		System.out.println("Name of the student is: " + name);
		System.out.println("Age of the student is: " + age);
	}

	public static void main(String args[]) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		MarkerInterfaceImplementation obj = new MarkerInterfaceImplementation(name, age);
		MarkerInterfaceImplementation obj2 = (MarkerInterfaceImplementation) obj.clone();
		obj2.display();
	}
}

/*Output:
 * Name of the student is: PriyaKayal Age of the student is: 23
 */