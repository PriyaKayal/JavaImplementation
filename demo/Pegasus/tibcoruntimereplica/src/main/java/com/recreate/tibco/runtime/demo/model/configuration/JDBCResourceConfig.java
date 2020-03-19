package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.constants.ResourceTypes;
import com.recreate.tibco.runtime.demo.model.interfaces.SharedResourceConfig;

public class JDBCResourceConfig implements SharedResourceConfig {
    private String name;
    private String driver;
    private int maxConnections;
    private int loginTimeout;
    private String connectionType;
    private boolean UseSharedJndiConfig;
    private String location;
    private String user;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getLoginTimeout() {
        return loginTimeout;
    }

    public void setLoginTimeout(int loginTimeout) {
        this.loginTimeout = loginTimeout;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public boolean isUseSharedJndiConfig() {
        return UseSharedJndiConfig;
    }

    public void setUseSharedJndiConfig(boolean useSharedJndiConfig) {
        UseSharedJndiConfig = useSharedJndiConfig;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return ResourceTypes.JDBC_RESOURCE;
    }
}
