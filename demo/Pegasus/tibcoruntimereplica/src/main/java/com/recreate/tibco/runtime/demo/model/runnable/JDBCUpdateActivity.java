package com.recreate.tibco.runtime.demo.model.runnable;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.springframework.jdbc.core.JdbcTemplate;

import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;

public class JDBCUpdateActivity implements RunnableActivity {
	JdbcTemplate jdbc;
	private DataSource dataSource;
	private String insertQuery;
	private List<String> params;
	private static final Logger LOGGER = Logger.getLogger(JDBCUpdateActivity.class.getName());

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbc = new JdbcTemplate(this.dataSource);
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public String getInsertQuery() {
		return insertQuery;
	}

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	@Override
	public Object run(Map inputBindings) {
		LOGGER.info("JdbcUpdateActivity executed");
		return jdbc.update(insertQuery, params.toArray());
	}
}
