package test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssf.system.dao.IOrderDao;
import com.ssf.system.dao.IProductDao;
import com.ssf.system.dao.IUserDao;
import com.ssf.system.model.User;
import com.ssf.system.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)//由Junit单元测试整合Spring
@ContextConfiguration("classpath:spring-context.xml")
public class SpringTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	IUserDao userDao;
	@Autowired
	IProductDao productDao;
	@Autowired
	IOrderDao orderDao;
	
	@Test
	public void orderTest(){
//		//IOC容器 # bean工厂 # Spring容器 # Spring上下文
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
//		ctx.getBean("user");
//		User user = ctx.getBean(User.class);  //Spring的Bean对象
//		
//		User user2 = new User();
//		//单例模式 singleton ， lazy-init延迟加载 懒加载
//		//解耦合 跟依赖类的解耦合
//		
//		//怎么把它注册进去
		
		System.out.println(orderDao.findAll().size());
		
		System.out.println(orderDao.queryAll(0,5).size());
	}
	
	@Test
	public void productTest(){
		System.out.println(productDao.findAll().size());
		
		System.out.println(productDao.queryAll(0,5).size());
	}
	
	@Test
	public void userDaoTest(){
		User u1 = userDao.getById(1);
		u1.setId(100);
		u1.setUpdateTime(new Date());
		System.out.println(u1);
		userService.aoptest2(u1);
		
		//userDao.test();
		//userDao.mybatisTest();
		
//		System.out.println(userDao.findAll());
//		User u1 = userDao.findById(1,"wang");
//		System.out.println("findByid:"+ u1);
//		User u2 = userDao.findById(1,"wang");
//		System.out.println("findByid:"+u2);
//		System.out.println(u1 == u2);
//		System.out.println(u1.equals(u2));
//		
//		User uu1 = userDao.getById(1);
//		User uu2 = userDao.getById(1);
//		System.out.println(uu1 == uu2);
//		System.out.println(uu1.equals(uu2)); 
//		userService.aoptest();
//		
//		System.out.println();
//		
//		userService.aoptest2();
//		//测试开启事务
//		User user = new User();
//		user.setId(999);
//		user.setPassword("123456");
//		user.setUsername("haha"); 
//		user.setCreateTime(new Date());
//		user.setUpdateTime(new Date());
//		userDao.save(user);
	}
}
