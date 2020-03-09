package main.java;
//@FunctionalInterface
//lamda expression implementation using functional interface (having only one abstract method)
interface MyName {
	String fullName(String name);
}

class Test {
	public static void main(String args[]) {
		String fName = "priya";
		MyName s = (String name) -> name.concat("Kayal");
		String nameObj = s.fullName(fName);
		System.out.println(nameObj);
	}
}
