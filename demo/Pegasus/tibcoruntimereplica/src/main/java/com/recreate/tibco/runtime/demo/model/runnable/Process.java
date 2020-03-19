package com.recreate.tibco.runtime.demo.model.runnable;

import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Process<T> {
    private String name;
    private ProcessFlow processFlow;
    private Map<String, RunnableActivity> activityMap;
    private Map<String, Object> returnValues;

    private String current;
    private static final Logger logger = LogManager.getLogger(Process.class);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcessFlow getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlow processFlow) {
        this.processFlow = processFlow;
    }

    public Map<String, RunnableActivity> getActivityMap() {
        return activityMap;
    }

    public void setActivityMap(Map<String, RunnableActivity> activityMap) {
        this.activityMap = activityMap;
    }

    public T run() {
        Arrays.asList(this.getClass().getDeclaredFields()).forEach(field -> {
            logger.info("FIELD IN PROCESS :: {} ", field.getName());
        });

        logger.info("ACTIVITIES :: {} ", activityMap.keySet().toArray());

        current = processFlow.next(current, this);
        do {
          logger.info("next process :: {} ", current);
          HashMap<String, String> inputBindings = new HashMap<>();
          // Run the activity and save the return
          // returnValues.put(current, activityMap.get(current).run(inputBindings));
          activityMap.get(current).run(inputBindings);
          // TODO : Compute process runtime values
          current = processFlow.next(current, returnValues);
        } while (current != null);
        return null;
    }
}
