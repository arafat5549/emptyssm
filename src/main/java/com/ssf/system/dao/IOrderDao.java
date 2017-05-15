package com.ssf.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssf.system.model.Order;

public interface IOrderDao {

	public List<Order> findAll();
	/**
	 * 分页查找
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Order> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
