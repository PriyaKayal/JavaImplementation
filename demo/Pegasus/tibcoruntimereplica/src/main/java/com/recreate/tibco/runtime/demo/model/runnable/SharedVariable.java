package com.recreate.tibco.runtime.demo.model.runnable;

import com.recreate.tibco.runtime.demo.model.interfaces.Element;

public class SharedVariable {
    private Element value;

    public Element getValue() {
        return value;
    }

    public void setValue(Element value) {
        this.value = value;
    }
}
