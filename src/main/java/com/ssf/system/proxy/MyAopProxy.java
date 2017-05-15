package com.ssf.system.proxy;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 我的AOP代理类
 * @author wyy
 * 2017年4月27日
 *
 */
public class MyAopProxy {

	public void breforPerformance(){
		System.out.println("--breforPerformance--");
	}
	
	public void afterPerformance(){
		System.out.println("--afterPerformance--");
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		// 加逻辑的时候, 不要依赖执行的的先后顺序
		System.out.println("MyProxy-------------- breforProceed().");
		Object o = pjp.proceed(); 
		System.out.println("MyProxy--------------- endProceed().");
		return o;
	}
}
