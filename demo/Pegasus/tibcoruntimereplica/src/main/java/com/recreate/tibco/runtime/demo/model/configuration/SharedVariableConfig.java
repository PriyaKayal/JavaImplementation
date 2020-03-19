package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.constants.ResourceTypes;
import com.recreate.tibco.runtime.demo.model.interfaces.Element;
import com.recreate.tibco.runtime.demo.model.interfaces.SharedResourceConfig;

import java.util.HashMap;

public class SharedVariableConfig implements SharedResourceConfig {
    private String name;
    private boolean persistent;
    private boolean multiEngine;
    private HashMap<String, Object> initialValues;
    private Element sharedElement;

    public boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isMultiEngine() {
        return multiEngine;
    }

    public void setMultiEngine(boolean multiEngine) {
        this.multiEngine = multiEngine;
    }

    public HashMap<String, Object> getInitialValues() {
        return initialValues;
    }

    public void setInitialValues(HashMap<String, Object> initialValues) {
        this.initialValues = initialValues;
    }

    public Element getSharedElement() {
        return sharedElement;
    }

    public void setSharedElement(Element sharedElement) {
        this.sharedElement = sharedElement;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getResourceType() {
        return ResourceTypes.SHARED_VARIABLE_RESOURCE;
    }
}
