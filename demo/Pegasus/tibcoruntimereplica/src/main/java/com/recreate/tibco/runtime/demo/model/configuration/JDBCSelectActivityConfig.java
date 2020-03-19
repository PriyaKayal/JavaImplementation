package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Activity;
import com.recreate.tibco.runtime.demo.model.interfaces.ActivityConfiguration;

public class JDBCSelectActivityConfig implements Activity {

    private JDBCActivityConfig config;

    @Override
    public ActivityConfiguration getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(ActivityConfiguration config) {
        this.config = (JDBCActivityConfig) config;
    }
}
