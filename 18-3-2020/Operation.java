package com.oops;
/**
 * @author Gnanapriya 
 *         enum is an user defined datatype that contains a list of
 *         members for which an integer constant is assigned starting from 0. in
 *         case of enum the numbers starting from 0 are not indexes whereas in
 *         case of an array they are indexes Also in case of enum you can assign
 *         your own constant values to the members that may or may not start
 *         from 0 and may or may not be in a sequence.
 */
public enum Operation {
	PLUS, MINUS, TIMES, DIVIDE;

	/* Enum must have private constructor only we cant access the class in that case!*/ 
	
	double calculate(double x, double y) {
		switch (this) {
		case PLUS:
			return x + y;
		case MINUS:
			return x - y;
		case TIMES:
			return x * y;
		case DIVIDE:
			return x / y;
		default:
			throw new AssertionError("Unknown operations " + this);
		}
	}
	public static void main(String[] args) {
	Operation o = Operation.PLUS;
	double val= o.calculate(5, 16);
	System.out.println(val);
	}

}

/*
 * public class EnumClass { int a; public static void main(String[] args) {
 * EnumClass obj = new EnumClass(); System.out.println(obj.a); } }
 */