package com.ivey.base.dao.hibernate;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ivey.base.dao.GenericDao;

public class GenericDaoHibernate<T, PK extends Serializable> extends JdbcDaoSupport implements GenericDao<T, PK> {

	protected final Log log = LogFactory.getLog(getClass());

	public T save(T object) {
		
		//super.getJdbcTemplate().execute(sql);
		return null;
	}

	public void remove(PK id) {
		
	}

	 
	 
}