package com.ivey.modules.member.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberBaseDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save() {
		System.err.println(jdbcTemplate.getDataSource());
		jdbcTemplate
				.execute("insert into T_USER (ADDRESS,EMAIL,MOBILE,USER_NAME,USER_PWD) values ('shanghai','xuegao521@163.com','1302326185','admin','admin')");
	}
}
