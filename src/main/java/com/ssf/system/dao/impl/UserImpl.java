package com.ssf.system.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssf.system.dao.IUserDao;
import com.ssf.system.model.User;
import com.ssf.utils.DBUtils;

//@Repository//IOC注解记得要放在实现类里面
public class UserImpl implements IUserDao
{

	@Autowired
	DBUtils dbUtils;
	
	@Override
	public void test() {
		List<User> lists = dbUtils.listBean("SELECT * FROM sys_user", User.class);
		System.out.println(lists);
	}
	
	//
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Override
	public void mybatisTest() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<User> lists = session.selectList("XXXX.findAll");
		System.out.println("mybatisTest:"+lists);
	}

	@Override
	public List<User> findAll() {
		SqlSession session = sqlSessionFactory.openSession();
		//session.selectOne(statement)
		return session.selectList("com.ssf.system.dao.IUserDao.findAll");
	}

	@Override
	public User findById(Integer id,String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
