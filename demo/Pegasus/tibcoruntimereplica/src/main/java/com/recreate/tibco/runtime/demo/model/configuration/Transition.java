package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Expression;

public class Transition {
    private String fromActivity;
    private String toActivity;
    private Expression condition;

    public String getFromActivity() {
        return fromActivity;
    }

    public void setFromActivity(String fromActivity) {
        this.fromActivity = fromActivity;
    }

    public String getToActivity() {
        return toActivity;
    }

    public void setToActivity(String toActivity) {
        this.toActivity = toActivity;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Transition getTransition() {
        return this;
    }
}
