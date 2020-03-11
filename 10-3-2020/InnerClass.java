package com.oops;
/**
 * 
 * @author Gnanapriya
 * Inner Class demonstration
 */
class O_Class 
{ 
	static int outer_x = 10; 
	int outer_y = 20; 
	private int outer_private = 30; 
	class InnerClass 
	{ 
		void display() 
		{ 
			System.out.println("outer_x = " + outer_x); 
			System.out.println("outer_y = " + outer_y); 
			System.out.println("outer_private = " + outer_private); 
		} 
	} 
} 

 class InnerClassDemo 
{ 
	public static void main(String[] args) 
	{ 
		O_Class outerObject = new O_Class(); 
		O_Class.InnerClass innerObject = outerObject.new InnerClass(); 
		innerObject.display(); 
	} 
} 

