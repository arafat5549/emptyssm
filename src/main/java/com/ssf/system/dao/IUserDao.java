package com.ssf.system.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.ssf.system.model.User;

public interface IUserDao {

	public void test();
	
	public void mybatisTest();
	
	public List<User> findAll();
	
	//分割符统一 我们使用: 或者 |
	@Cacheable(value="indexCache",key="'IUserDao:findById:'+#id")
	public User findById(Integer id,String username);
	
	public User getById(Integer id);
	
	public void save(User user);
}
