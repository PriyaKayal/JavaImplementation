package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.ActivityConfiguration;

import java.util.List;

public class JDBCActivityConfig implements ActivityConfiguration {
    private int timeout;
    private boolean commit;
    private Integer maxRows;
    private String dataSourceLink;
    private String statement;
    private ComplexElement outputClass;
    private List<String> preparedParams;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isCommit() {
        return commit;
    }

    public void setCommit(boolean commit) {
        this.commit = commit;
    }

    public Integer getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    public String getDataSourceLink() {
        return dataSourceLink;
    }

    public void setDataSourceLink(String dataSourceLink) {
        this.dataSourceLink = dataSourceLink;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public ComplexElement getOutputClass() {
        return outputClass;
    }

    public void setOutputClass(ComplexElement outputClass) {
        this.outputClass = outputClass;
    }

    public List<String> getPreparedParams() {
        return preparedParams;
    }

    public void setPreparedParams(List<String> preparedParams) {
        this.preparedParams = preparedParams;
    }
}