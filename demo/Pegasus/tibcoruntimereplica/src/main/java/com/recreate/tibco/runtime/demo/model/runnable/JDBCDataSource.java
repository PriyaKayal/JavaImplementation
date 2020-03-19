package com.recreate.tibco.runtime.demo.model.runnable;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.logging.Logger;

public class JDBCDataSource {
    public DataSource dataSource;
    private DefaultVariable jdbcUrl;
    private DefaultVariable driver;
    private DefaultVariable username;
    private DefaultVariable password;

    private static final Logger logger = Logger.getLogger(JDBCDataSource.class.getName());

    public void instantiateDataSource() {
        try {
            logger.info("Configuration :: " + jdbcUrl.getValue() + " :: " + password.getValue());
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(driver.getValue());
            dataSourceBuilder.url(jdbcUrl.getValue());
            dataSourceBuilder.username(username.getValue());
            dataSourceBuilder.password(password.getValue());
            this.dataSource = dataSourceBuilder.build();
            logger.info(" Datasource created !! " + this.dataSource.getConnection().getAutoCommit());
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }
    }

    public DefaultVariable getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(DefaultVariable jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public DefaultVariable getDriver() {
        return driver;
    }

    public void setDriver(DefaultVariable driver) {
        this.driver = driver;
    }

    public DefaultVariable getUsername() {
        return username;
    }

    public void setUsername(DefaultVariable username) {
        this.username = username;
    }

    public DefaultVariable getPassword() {
        return password;
    }

    public void setPassword(DefaultVariable password) {
        this.password = password;
    }
}
