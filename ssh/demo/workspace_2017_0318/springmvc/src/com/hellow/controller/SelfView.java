package com.hellow.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component		//将组件添加到容器
public class SelfView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().print("self view : " + new Date());;
	}

}
