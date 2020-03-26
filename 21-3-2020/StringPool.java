package com.oops;

/**
 * @author Gnanapriya
 *  String Pool
 */
public class StringPool {

	String sVar = "Priya";
	String pVar = "Priya";
	String spVar = new String("Priya");
	String spspVar = new String("Priya").intern();

	public static void main(String[] args) {
		StringPool s = new StringPool();
		/*
		 * System.out.println(Integer.toHexString(s.sVar.hashCode()));
		 * System.out.println(Integer.toHexString(s.pVar.hashCode()));
		 * System.out.println(Integer.toHexString(s.spVar.hashCode()));
		 * System.out.println(Integer.toHexString(s.spspVar.hashCode()));
		 */
		System.out.println(s.sVar == s.pVar);
		System.out.println(s.spVar == s.spspVar);
		System.out.println(s.sVar == s.spspVar);
		System.out.println(s.pVar.equals(s.spVar));
	}
}
