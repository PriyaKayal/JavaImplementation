package com.recreate.tibco.runtime.demo.model.interfaces;

import java.util.Map;

public interface RunnableActivity<T> {
	public T run(Map inputBindings);

}
