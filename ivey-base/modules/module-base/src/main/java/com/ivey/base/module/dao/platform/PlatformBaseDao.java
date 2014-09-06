package com.ivey.base.module.dao.platform;

import org.springframework.stereotype.Component;

import com.ivey.base.module.dao.ModulesBaseDao;

@Component
public class PlatformBaseDao extends ModulesBaseDao {


	public void save() {
		jdbcTemplate.execute("insert into T_REGION (NAME) values('beijing')");
	}
}
