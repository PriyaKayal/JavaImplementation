package main.java.override;

import java.util.logging.Logger;

class BaseClass {
	public void display() {
		Logger logger = Logger.getLogger(OverrideAnnotation.class.getName());
		logger.info("Parent Invoked");
	}
}

class ChildClass extends BaseClass {
	@Override
	public void display() {
		Logger logger = Logger.getLogger(OverrideAnnotation.class.getName());
		logger.info("Child Invoked");
	}
}

/**
 * 
 * @author Gnanapriya
 * @override annotation is maintain readability of code and also we are telling
 *           the compiler that, we are overriding the method match it with the
 *           super type and If anything is not fitting just generate the error
 */

class OverrideAnnotation {
	Logger logger = Logger.getLogger(OverrideAnnotation.class.getName());

	public static void main(String args[]) {
		Logger logger = Logger.getLogger(OverrideAnnotation.class.getName());
		logger.info("Info Log");
		BaseClass test = new ChildClass();
		test.display();
	}
}