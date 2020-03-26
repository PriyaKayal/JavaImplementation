package com.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gnanapriya 
 * Array recollection
 */
public class ArrayClass {

	public static void main(String[] args) {
		int a[] = new int[10];
		int b[] = { 16, 5, 9, 2 };
		List<Integer> list = new ArrayList<Integer>();
		list.add(16);
		list.add(5);
		/* list.remove(1); */
		Integer c[] = Arrays.copyOf(list.toArray(), list.size(), Integer[].class);// it will return object array
		for (Integer i : c) {
			System.out.println(i);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
		}
	}
}