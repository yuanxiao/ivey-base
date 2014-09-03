package com.ivey.base.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {

	 
	T save(T object);

	void remove(PK id);

	 
}