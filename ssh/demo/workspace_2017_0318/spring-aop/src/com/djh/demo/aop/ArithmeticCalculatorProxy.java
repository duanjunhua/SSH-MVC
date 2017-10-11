package com.djh.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorProxy {
	private ArithmeticCalculator calculator;
	public ArithmeticCalculatorProxy(ArithmeticCalculator calculator) {
		// TODO Auto-generated constructor stub
		this.calculator = calculator;
	}
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = calculator.getClass().getClassLoader();
		//代理对象的类型,即其中有哪些方法
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};		
		//当调用代理对象时,其执行的代码
		InvocationHandler handler = new InvocationHandler() {
			/**
			 * proxy： 正在返回的那个代理对象,一般情况下,在invoke方法中不适用该对象
			 * method： 正在被调用的方法
			 * args： 调用方法时传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				String methodName = method.getName();
				System.out.println("The method " + methodName + "begins with " + Arrays.asList(args));
				Object result = method.invoke(calculator, args);
				System.out.println("The method " + methodName + "end with " + result);
				return result;
			}
		};
		
		//获取动态代理对象
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
