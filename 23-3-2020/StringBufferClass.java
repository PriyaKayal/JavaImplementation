package com.oops;
/**
 * @author Gnanapriya
 * String Buffer (Thread safe) and String Builder (High Performance)
 */
public class StringBufferClass {
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		StringBuilder sobj = new StringBuilder("Priya");
		for (int i = 0; i < 100000; i++) {
			sobj.append("Kayal");
		}

		long end1 = System.currentTimeMillis();
		long total_time = end1 - start1;

		System.out.println("Time taken to execute" + " String Builder = " + total_time);

		long start2 = System.currentTimeMillis();
		StringBuffer sbfobj = new StringBuffer("Priya");
		for (int i = 0; i < 100000; i++) {
			sbfobj.append("Kayal");
		}

		long end2 = System.currentTimeMillis();
		long total_time1 = end2 - start2;

		System.out.println("Time taken to execute" + " String Buffer = " + total_time1);
	}
}
