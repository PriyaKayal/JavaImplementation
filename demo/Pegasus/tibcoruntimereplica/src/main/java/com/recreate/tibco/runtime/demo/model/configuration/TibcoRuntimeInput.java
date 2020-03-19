package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.configuration.DefaultVariableConfig;
import com.recreate.tibco.runtime.demo.model.interfaces.SharedResourceConfig;

import java.util.List;

public class TibcoRuntimeInput {
    private List<DefaultVariableConfig> defaultVariableConfigs;
    private List<SharedResourceConfig> resources;
    private List<ProcessConfig> processes;

    public List<DefaultVariableConfig> getDefaultVariableConfigs() {
        return defaultVariableConfigs;
    }

    public void setDefaultVariableConfigs(List<DefaultVariableConfig> defaultVariableConfigs) {
        this.defaultVariableConfigs = defaultVariableConfigs;
    }

    public List<SharedResourceConfig> getResources() {
        return resources;
    }

    public void setResources(List<SharedResourceConfig> resources) {
        this.resources = resources;
    }

    public List<ProcessConfig> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ProcessConfig> processes) {
        this.processes = processes;
    }
}
