package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.constants.ResourceTypes;
import com.recreate.tibco.runtime.demo.model.interfaces.Element;
import com.recreate.tibco.runtime.demo.model.interfaces.SharedResourceConfig;

public class SchemaResourcesConfig implements SharedResourceConfig {
    private String name;
    private Element config;

    public Element getConfig() {
        return config;
    }

    public void setConfig(Element config) {
        this.config = config;
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
        return ResourceTypes.SCHEMA_RESOURCE;
    }
}
