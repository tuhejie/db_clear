package com.db_clear.services.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.db_clear.aops.LoggerManage;
import com.db_clear.services.base.impl.BaseService;
import com.db_clear.utils.math.NumberUtils;

import tk.mybatis.mapper.common.Mapper;

public class BaseServiceImpl<T> implements BaseService<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected Mapper<T> mapper;

	@Override
	@LoggerManage(description="S:保存记录")
	public int save(T t) throws Exception {
		// TODO Auto-generated method stub
		if (t == null) {
			return NumberUtils.INTEGER_ZERO;
		}
		return mapper.insertSelective(t);
	}
	
	@Override
	@LoggerManage(description="S:更新记录")
	public int update(T t) throws Exception {
		// TODO Auto-generated method stub
		if (t == null) {
			return NumberUtils.INTEGER_ZERO;
		}
		return mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	@LoggerManage(description="S:根据id查找记录")
	public T findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			return null;
		}
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	@LoggerManage(description="S:根据id删除记录")
	public int delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			return NumberUtils.INTEGER_ZERO;
		}
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@LoggerManage(description="S:查找所有记录列表")
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	
	@Override
	@LoggerManage(description="S:根据实体类条件查找所有记录列表")
	public List<T> findByEntity(T t) throws Exception {
		if (t == null) {
			return null;
		}
		return mapper.select(t);
	}

	@Override
	@LoggerManage(description="S:根据实体对象删除记录")
	public int delete(T t) throws Exception {
		// TODO Auto-generated method stub
		if (t == null) {
			return NumberUtils.INTEGER_ZERO;
		}
		return mapper.delete(t);
	}

}
