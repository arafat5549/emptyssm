package com.ssf.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssf.system.dao.IUserDao;
import com.ssf.system.model.User;

@Service
public class UserService {

	@Autowired
	IUserDao userDao;
	
	//@Transactional //使用事务注解#开启事务
	public void aoptest(){
		System.out.println("执行AOPtest");
	}
	//@Transactional(readOnly=true)
	public void save(User user){
		System.out.println("执行save");
		userDao.save(user);
	}
	
	public void aoptest2(User user){
		System.out.println("执行aoptest2");
		//userDao.save(user);
		System.out.println(userDao.findAll());
	}
}
