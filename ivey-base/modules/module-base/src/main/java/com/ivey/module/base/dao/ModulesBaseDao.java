package com.ivey.module.base.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ModulesBaseDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}
