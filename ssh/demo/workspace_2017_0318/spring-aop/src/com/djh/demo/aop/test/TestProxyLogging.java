package com.djh.demo.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//
////import com.djh.demo.aop.ArithmeticCalculatorImp;
//import com.djh.demo.aop.aspect.ArithmeticCalculator;
//import com.djh.demo.aop.ArithmeticCalculator;
//import com.djh.demo.aop.ArithmeticCalculatorImp;
//import com.djh.demo.aop.ArithmeticCalculatorProxy;

import com.demo.xml.aop.aspect.ArithmeticCalculator;

public class TestProxyLogging {

//	@Test
//	public void testProxyLogging(){
//		ArithmeticCalculator calculator = new ArithmeticCalculatorImp();
//		
//		//代理对象
//		ArithmeticCalculator proxy = new ArithmeticCalculatorProxy(calculator).getLoggingProxy();
//		
//		proxy.add(1, 2);
//		System.out.println("-------------------");
//		proxy.div(4, 2);
//	}
	
//	@Test
//	public void testAspectAnnotation(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aspect-baseXml.xml");
//		
//		ArithmeticCalculator calculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
//		
//		int result = calculator.add(2, 3);
//		System.out.println("result : " + result);
//		
//		result = calculator.div(10, 5);
//		System.out.println("result : " + result);
//	}
	
	
	@Test
	public void testAspectXml(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aspect-baseAnnotation.xml");
		ArithmeticCalculator calculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		int result = calculator.add(2, 3);
		System.out.println("result : " + result);
		
		result = calculator.div(10, 0);
		System.out.println("result : " + result);
	}
}
