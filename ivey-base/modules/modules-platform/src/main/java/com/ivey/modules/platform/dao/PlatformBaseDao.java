package com.ivey.modules.platform.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class PlatformBaseDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save() {
		jdbcTemplate.execute("insert into T_REGION (NAME) values('beijing')");
	}
}
