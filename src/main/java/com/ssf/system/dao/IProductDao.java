package com.ssf.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import com.ssf.system.model.Product;

public interface IProductDao {

	List<Product> findAll();
	/**
	 * 分页查找
	 * @param offset
	 * @param limit
	 * @return
	 */
	//@Cacheable()
	List<Product> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
