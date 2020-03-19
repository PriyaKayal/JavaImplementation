package com.recreate.tibco.runtime.demo.model.interfaces;

public interface Element<T> {
    T getValue();
    void setValue(T value);
    Class getClassDefinition();
}
