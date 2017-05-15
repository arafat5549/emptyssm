package com.ssf.system.web;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.system.dao.IUserDao;
import com.ssf.system.model.User;

@Controller					//1.扫描进入IOC容器 作为WEB层的Bean对象
@RequestMapping("/mvc")		//2.指定你所对应的url路径
public class MVCController {

	@Autowired
	private IUserDao userDao;
	
	//3.最终的url指定到方法那一级别,默认get和post都可以
	
	//优点：请求参数封装#为了简化WEB开发(应用到了反射前台是你有对应参数名的getter和setter方法)
	@RequestMapping(value="/",method=RequestMethod.GET)	
	public void v1(User user ,PrintWriter pw){
		pw.write(user.toString());
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)	
	public void v1_post(User user ,PrintWriter pw){
		pw.write(user.toString());
	}
	
	//myshop:  localhost:8080/ssm/user?method=login&
	//WEBmvc:  localhost:8080/ssm/mvc/login
	
	
	//优点：url可以指定到方法那一级别#支持灵活的URL到页面控制器的映射；
	//登录1.跳转到登录页面
	@RequestMapping(value="/login",method=RequestMethod.GET)	
	public String loginUI(){
		//优点：简化了页面跳转，非常容易与其他视图技术集成，如Velocity、FreeMarker等等，因为模型数据不放在特定的API里，而是放在一个Model里（Map数据结构实现，因此很容易被其他框架使用）；
		return "login";
	}
	//登录2.执行登录操作
	@RequestMapping(value="/login",method=RequestMethod.POST)	
	public String login(User user){
		return "home";   
	}
	
	//优点：RESTFUL风格  user/list/1  用url来传参
	@RequestMapping(value="/rest/{id}",method=RequestMethod.GET )	
	public void rest(PrintWriter pw,@PathVariable("id")String id){
		pw.write(id); 
	}
	
	//优点：非常容易整合JSON等数据处理，有利于手机端的数据操作
	@RequestMapping(value="/json",method=RequestMethod.GET)	
	@ResponseBody
	public User json(){
		return userDao.getById(1);
	}
	//优点：6.天然跟Spring整合(本身就是spring的一个模块)
    //优点：7.使用注解配置的方式能极大简化配置(约定大于配置#你只需要修改你要改变的部分 提供默认配置)
}
