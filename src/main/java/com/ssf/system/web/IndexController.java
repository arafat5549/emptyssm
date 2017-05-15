package com.ssf.system.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssf.system.model.TestModel;
import com.ssf.system.model.User;

@Controller
@RequestMapping("/")
public class IndexController {
	//尽量使用日记的接口类
	//debug info error、
	//开发时候使用低门槛的日记debug级别  发布使用高门槛的日记error
	Logger log = LoggerFactory.getLogger(IndexController.class);
	
	//URL指定到方法那一级别   /index.jpg
	@RequestMapping("/index")   //选择一个视图处理器来做
	public String index(HttpServletRequest req){
		//1.原始的方式来获取参数
		String a = req.getParameter("a");
		System.out.println(a);
		
		return "home";
	} 
	//1.参数的封装 简化参数的获取
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ModelAndView userParam(User user,TestModel testmodel,
			HttpServletRequest req,
			Model model,
			ModelAndView mv){
		
		log.info(user.toString());
		log.debug(testmodel.toString()); 
		log.error("error级别的LOg");
		
		//req.setAttribute("user", user);
		//model.addAttribute("testmodel",testmodel);
		
		//mv = new ModelAndView("home");
		mv.setViewName("home");
		mv.addObject("testmodel",testmodel);
		mv.addObject("user",user);
		return mv;
	}
	
	
	 //绑定你的Date数据类型
	 @InitBinder
	 public void initBinder(ServletRequestDataBinder binder){
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	             true));
	 }
	
	 //处理时间格式
	 @RequestMapping("/date")
	 public String date(Date losttime){
	     System.out.println(losttime);//直接将string格式化转化为Date格式
	     
	     //SimpleDateFormat fomate= new SimpleDateFormat("YYYY/MM/dd");
	     //fomate.parse(time);
	     //return "hello";
	   return "redirect:index";
	 }
	    
	//上传文件
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
	 public String upload(HttpSession session,@RequestParam("file") MultipartFile file){
		 uploadImage(session, file);
		 return "home"; 
	 }
	 
	 private  void uploadImage(HttpSession session,MultipartFile file) {
	        String fileName = new Date().getTime() + ".jpg";
	        String path = session.getServletContext().getRealPath("/upload");
	        String serverFile = path + "/" + fileName;
	        session.setAttribute("imgName", "/upload/" + fileName);
	        try {
	            log.info(path);
	            System.out.println(path);
	            if (!new File(path).exists()) {
	                new File(path).mkdirs();
	            }
	            if (!new File(serverFile).exists()) {
	                new File(serverFile).createNewFile();
	            }
	            byte[] bytes = file.getBytes();
	            BufferedOutputStream stream =
	                    new BufferedOutputStream(new FileOutputStream(new File(serverFile)));
	            stream.write(bytes);
	            stream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 //restful风格
	 @RequestMapping(value="/rest/{id}",method=RequestMethod.GET)
	   public String put(@PathVariable("id") Integer id){
	      System.out.println("put"+id);
	      return "home";
	  }   
	 //json字符串的处理
	 @ResponseBody
	 @RequestMapping("/json")
	 public  User get(){
	     User u = new User();
	     u.setId(1);
	     //u.setUsername("jayjay"); 
	     u.setAvartarUrl("123456");
	     u.setCreateTime(new Date());
	     return u;
	}
	 //处理JSON的时间格式
	 
	 //全局错误处理
	 
	 //参数验证 整合Hibernate-validation
}
