package com.oops;

interface CanBark {

}

class SoftDogClass {

}

public class DogClass implements CanBark {

	public void isBarking(Object o) {
		if (o instanceof CanBark) {
			DogClass d = (DogClass) o;
			d.bark();
//			System.out.println("Barking");
		} else {
			System.out.println("I am Soft, i cant Bark");
		}
	}

	public void bark() {
		System.out.println("Hey I can Barking");
	}

	public static void main(String[] args) {
		DogClass d = new DogClass();
		SoftDogClass s = new SoftDogClass();
		d.isBarking(s);
		d.isBarking(d);
	}
}
