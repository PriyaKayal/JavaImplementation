package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Activity;
import com.recreate.tibco.runtime.demo.model.interfaces.Element;

import java.util.HashMap;
import java.util.List;

public class ProcessConfig {
    private String name;
    // Start
    private Element start;

    // Return
    private Element returnType;

    // Process variables
    private List<Element> processVariables;

    // Activities
    private HashMap<String, Activity> activities;

    // Groups?
    // Transitions
    private List<Transition> transitions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getStart() {
        return start;
    }

    public void setStart(Element start) {
        this.start = start;
    }

    public Element getReturnType() {
        return returnType;
    }

    public void setReturnType(Element returnType) {
        this.returnType = returnType;
    }

    public List<Element> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(List<Element> processVariables) {
        this.processVariables = processVariables;
    }

    public HashMap<String, Activity> getActivities() {
        return activities;
    }

    public void setActivities(HashMap<String, Activity> activities) {
        this.activities = activities;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
