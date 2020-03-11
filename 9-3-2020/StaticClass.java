package com.oops;

/**
 * 
 * @author Gnanapriya, Static nested class can access static member of outer
 *         class
 */
class OuterClass {
	static int outer_x = 10;
	int outer_y = 20;
	private static int outer_private = 30;

	static class StaticNestedClass {
		void display() {
			System.out.println("outer_x = " + outer_x);
			System.out.println("outer_private = " + outer_private);
			/**
			 * The following statement will give compilation error as static nested class
			 * cannot directly access non-static membera System.out.println("outer_y = " +
			 * outer_y);
			 */
		}
	}
}

class StaticNestedClassDemo {
	public static void main(String[] args) {
		OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
		nestedObject.display();
	}
}
