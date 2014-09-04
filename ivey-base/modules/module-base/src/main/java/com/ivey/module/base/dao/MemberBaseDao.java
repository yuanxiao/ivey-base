package com.ivey.module.base.dao;

import org.springframework.stereotype.Component;


@Component
public class MemberBaseDao extends ModulesBaseDao{

	public void save() {
		System.err.println(jdbcTemplate.getDataSource());
		jdbcTemplate
				.execute("insert into T_USER (ADDRESS,EMAIL,MOBILE,USER_NAME,USER_PWD) values ('shanghai','xuegao521@163.com','1302326185','admin','admin')");
	}
}
