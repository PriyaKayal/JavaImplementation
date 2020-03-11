package com.oops;

/**
 * @author Gnanapriya, Object creation using clone() method Using clone() method:
 *         It is used to make clone of an object. It is the easiest and most
 *         efficient way to copy an object.
 *
 */
class Oops implements Cloneable {
	int O_id;
	String O_name;

	// default constructor
	Oops(String O_name, int O_id) {
		this.O_id = O_id;
		this.O_name = O_name;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Test {

	public static void main(String args[]) {

		try {
			Oops ob1 = new Oops("Priya", 311);
			Oops ob2 = (Oops) ob1.clone();
			System.out.println(ob1.O_id + ", " + ob1.O_name);
			System.out.println(ob2.O_id + ", " + ob2.O_name);
		} catch (CloneNotSupportedException c) {
			System.out.println("Exception: " + c);
		}
	}
}
