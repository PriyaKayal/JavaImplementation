package com.oops;
/**
 * @author Gnanapriya Arumugam
 * Basics
 */
public class JavaFunctions {
	public static void main(String[] args) {
		String txt = "Please locate where 'locate' occurs!";
		String myStr = "Hello";
		System.out.println(myStr.hashCode());
		/*
		 * returns the hash code of a string s[0]*31^(n-1) + s[1]*31^(n-2) + ... +
		 * s[n-1]
		 */
		System.out.println(txt.indexOf("locate")); // Outputs 7
		System.out.println(Math.random());
		/*
		 * returns a random number between 0 (inclusive), and 1 (exclusive):
		 */
		String str = "priya@kayal"; 
        String[] arrOfStr = str.split("@", 2); 
  
        for (String a : arrOfStr) 
            System.out.println(a); 
    } 
	}

/*Output:
 * 69609650
 * 7
 * 0.08146808552135143 
 * priya 
 * kayal
 */

