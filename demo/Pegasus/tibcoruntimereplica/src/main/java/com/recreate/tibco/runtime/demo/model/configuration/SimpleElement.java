package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Element;

public class SimpleElement<T> implements Element<T> {
    private T value;
    private Class<T> type;

    public SimpleElement(Class<T> type) {
        this.type = type;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Class getClassDefinition() {
        return type;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
