package com.db_clear.services.base.impl;

import java.util.List;

public interface BaseService<T> {

	int delete(Long id) throws Exception;

	int delete(T t) throws Exception;

	List<T> findAll() throws Exception;
	
	List<T> findByEntity(T t) throws Exception;

	T findById(Long id) throws Exception;

	int save(T t) throws Exception;
	
	int update(T t) throws Exception;

}
