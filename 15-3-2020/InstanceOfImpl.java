package com.oops;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author Gnanapriya
 * 		   Naming Convention, Logger, Instanceof implementations
 */
class $_$ {

}

class ClassB {
}

public class InstanceOfImpl extends $_$ {
	private static final Logger LOGGER = Logger.getLogger(InstanceOfImpl.class.getName());

	public static void main(String[] args) {
		$_$ object = new InstanceOfImpl();
		LOGGER.log(Level.INFO, "Instance of usage", object instanceof InstanceOfImpl);
		System.out.println(object instanceof $_$);
		InstanceOfImpl obj;
	}
}


/*Output:
 * Mar 20, 2020 12:56:10 PM com.oops.InstanceOfImpl main INFO: Instance of usage
 * true
 */