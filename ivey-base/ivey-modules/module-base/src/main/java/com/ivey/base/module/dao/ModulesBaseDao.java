package com.ivey.base.module.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ModulesBaseDao{

	
	@Autowired
	protected JdbcTemplate	jdbcTemplate;

	protected <T> void fillEntity(T t,ResultSet rs){
		Field[] fields = t.getClass().getDeclaredFields();
		String fieldName = null;
		Object fieldValue = null;
		Method method = null;
		for (Field field : fields){
			fieldName = field.getName();
			try{
				fieldValue = rs.getObject(fieldName);
				fieldName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				method = t.getClass().getMethod(fieldName, field.getType());
				method.invoke(t, fieldValue);
			}catch (SQLException sqle){

			}catch (SecurityException e){
				
			}catch (NoSuchMethodException e){
				
			}catch (IllegalArgumentException e){
				
			}catch (IllegalAccessException e){
				
			}catch (InvocationTargetException e){
				
			}
		}
	}
}
