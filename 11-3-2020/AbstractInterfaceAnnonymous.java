package com.oops;

/**
 * @author Gnanapriya
 *
 */
interface i {
	void display();
}

abstract class A {
	abstract void display();
}

class B extends A implements i {

	public static void main(String args[]) {
		/**
		 * Annonymous Inner Class
		 */
		A a = new A() {
			@Override
			void display() {
				System.out.println("Abstract method Implementation");
			}
		};
		B obj = new B();
		obj.display();
		a.display();
	}

	@Override
	public void display() {
		System.out.println("Interface implementation");
	}

}