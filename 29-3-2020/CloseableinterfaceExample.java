package com.oops;

import java.util.Scanner;

/**
 * @author Gnanapriya Arumugam 
 * 		   Both are interfaces used to close resources
 *         Closeable interface can be closed by calling .close() auto closeable
 *         -automates the process of closing a resource,thus preventing memory
 *         leaks (managed by try-with-resources) throws IO exception
 * 
 *         Any class that implements Closeable also implements AutoCloseable.
 *         Both AutoCloseable and Closeable only include 1 abstract method
 *         close() thus both allows a class to be used as a resource of the
 *         try-with-resources, which allows closing such resources automatically
 *         at the end of a block,
 */
public class CloseableinterfaceExample {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// internally any input or output stream will implement closeable interface ,
		// all readers and writers
		// will implement closeable interface , only one close method, only if we close
		// the resource it will free up the memory
		int a = in.nextInt();
		System.out.println(a);
		in.close();
	}
}
