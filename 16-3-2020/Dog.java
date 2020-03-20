package com.oops;
/**
 * @author Gnanapriya
 * 		   Instance of implementation
 */
class Animal {
}

class Cat extends Animal {
	public void printCat() {
		System.out.println("Cat");
	}

}

class Dog extends Animal {
	public void printDog() {
		System.out.println("Dog");
	}

	void invoke(Animal a) {
		if (a instanceof Cat) {
			Cat c = (Cat) a;
			c.printCat();
		} else if (a instanceof Dog) {
			Dog d = (Dog) a;
			d.printDog();
		}
	}

	public static void main(String[] args) {
		Animal a = new Dog();
		Dog d = new Dog();
		d.invoke(a);
	}
}

/*
 * Output: Dog
 */