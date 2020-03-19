package com.recreate.tibco.runtime.demo.model.runnable;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;

public class JDBCSelectActivity implements RunnableActivity {
    private DataSource dataSource;
    private String selectQuery;
    private List<String> params;
    private Class outputType;
    private static final Logger LOGGER = Logger.getLogger(JDBCSelectActivity.class.getName());

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getSelectQuery() {
        return selectQuery;
    }

    public void setSelectQuery(String selectQuery) {
        this.selectQuery = selectQuery;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public Class getOutputType() {
        return outputType;
    }

    public void setOutputType(Class outputType) {
        this.outputType = outputType;
    }

    @Override
    public Object run(Map inputBindings) {
    	LOGGER.info("JdbcSelectActivity executed");
        return outputType;
    }
}
