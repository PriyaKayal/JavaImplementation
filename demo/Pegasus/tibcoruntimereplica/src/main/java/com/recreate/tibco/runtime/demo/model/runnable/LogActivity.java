package com.recreate.tibco.runtime.demo.model.runnable;

import java.util.Map;
import java.util.logging.Logger;

import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;

public class LogActivity implements RunnableActivity {
	private static final Logger LOGGER = Logger.getLogger(LogActivity.class.getName());
	@Override
	public Object run(Map inputBindings) {
		LOGGER.info("Static Condition failed");
		return null;
	}

}
