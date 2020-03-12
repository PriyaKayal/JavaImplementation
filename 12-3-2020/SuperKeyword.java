package com.oops;

/**
 * @author Gnannapriya
 * 		   SuperKeyword invocation
 */
public class SuperKeyword {
	void name() {
		System.out.println("Priya");
	}
}

class Myname extends SuperKeyword {
	void name() {
		System.out.println("Gnanapriya");
	}

	void nickname() {
		System.out.println("Kayal");
	}

	void displayName() {
		super.name();
		nickname();
	}
}

class SuperInvocation {
	public static void main(String args[]) {
		Myname d = new Myname();
		d.displayName();
	}
}