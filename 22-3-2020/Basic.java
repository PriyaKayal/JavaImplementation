package com.oops;
/**
 * @author Gnanapriya
 * returns the current time in milliseconds
 */
public class Basic {
public static void main(String[] args) {
		/*
		 * public - To invoke from any where by JVM 
		 * static - JVM should call this method with out existing objects also 
		 * void - Main method won’t return any thing to JVM 
		 * main - Name of method which is classified by JVM 
		 * String[] args - CommandLine arguments
		 */
	// returns the current time in milliseconds
    System.out.print("Current Time in milliseconds = ");
    System.out.println(System.currentTimeMillis());
	}
}
