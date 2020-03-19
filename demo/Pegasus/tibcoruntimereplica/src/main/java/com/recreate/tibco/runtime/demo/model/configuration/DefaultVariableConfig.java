package com.recreate.tibco.runtime.demo.model.configuration;

public class DefaultVariableConfig {
    private String name;
    private String value;
    private boolean deploymentSettable;
    private boolean serviceSettable;
    private String type;
    private String modTime;
    private String accessor;

    public String getName() {
        return name;
    }

    public String getAccessor() {
        return accessor;
    }

    public void setAccessor(String accessor) {
        this.accessor = accessor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDeploymentSettable() {
        return deploymentSettable;
    }

    public void setDeploymentSettable(boolean deploymentSettable) {
        this.deploymentSettable = deploymentSettable;
    }

    public boolean isServiceSettable() {
        return serviceSettable;
    }

    public void setServiceSettable(boolean serviceSettable) {
        this.serviceSettable = serviceSettable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }
}
