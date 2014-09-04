package com.ivey.module.base.dao;

import org.springframework.stereotype.Component;

@Component
public class PlatformBaseDao extends ModulesBaseDao {


	public void save() {
		jdbcTemplate.execute("insert into T_REGION (NAME) values('beijing')");
	}
}
