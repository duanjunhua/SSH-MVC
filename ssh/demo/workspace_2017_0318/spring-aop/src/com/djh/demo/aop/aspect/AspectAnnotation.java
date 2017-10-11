package com.djh.demo.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class AspectAnnotation {
	/**
	 * 用于声明切入点表达式,该方法中不需要填入其他的代码
	 */
	@Pointcut("execution(public int com.djh.demo.aop.aspect.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression(){}
	
	
	@Before("com.djh.demo.aop.aspect.AspectAnnotation.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		//validate code ...
		
	}
	
	//"*"表示所有方法, ".."代表可变数量的参数
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		//获取执行的切入点传入参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends ");
	}
	
	@AfterReturning(value="declareJoinPointExpression()", returning="result")
	public void afterRunning(JoinPoint joinPoint, Object result){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends with result: " + result);
	}
	
	@AfterThrowing(value="declareJoinPointExpression()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		//获取执行的方法名
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " occurs exception : " + ex);
	}
}
