package com.demo.xml.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class AspectXml {
	
	public void beforeMethod(JoinPoint joinPoint){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		//获取执行的切入点传入参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	public void afterMethod(JoinPoint joinPoint){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends ");
	}
	
	public void afterRunning(JoinPoint joinPoint, Object result){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends with result: " + result);
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " occurs exception : " + ex);
	}
}
