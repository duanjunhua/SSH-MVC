package com.hellow.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.jfxmedia.events.NewFrameEvent;

@RequestMapping("/test")
@Controller
public class HelloWorld {
	
	
	@RequestMapping("/testView")
	public String testModelAttribute(){
		System.out.println("test View");
		return "selfView"; 			//自定义视图类名首字母小写
	}
	
	@ModelAttribute
	public void getStd(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map){
		System.out.println("getStd method...");
		if(id!=null){
			Student student = new Student(1, "Michael", 24, "CN");
			map.put("student", student);
		}
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("student")Student student){	//@ModelAttribute("student")中student应与@ModelAttribute修饰的方法中map添加的key一致
		System.out.println("ModelAttribute: " + student);
		return "success"; 
	}
	
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		
		String viewName = "success";
		ModelAndView modelAndView = new ModelAndView(viewName);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("names", Arrays.asList("Michael", "Kay", "David"));
		modelAndView.addAllObjects(modelMap);
		modelAndView.addObject("age", "11");
		return modelAndView;
	}
	
	
	/**
	 * 返回值会通过org.springframework.web.servlet.view.InternalResourceViewResolver视图解析器进行解析,解析方式如下：
	 * 	prefix + return result + suffix, 即/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloworld")			//使用@RequestMapping注解来映射请求的url
	public String hello(){
		System.out.println("Hello World!");
		return "success";
	}
	
	@RequestMapping("/requestMapping")			//使用@RequestMapping注解来映射请求的url
	public String requestMapping(){
		System.out.println("requestMapping");
		return "request";
	}
}
