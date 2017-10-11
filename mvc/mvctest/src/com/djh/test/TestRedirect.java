package com.djh.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRedirect
 */
@WebServlet("/TestRedirect")
public class TestRedirect extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求转发,只能是在当前的WEB应用资源,如下是错误的
//		request.getRequestDispatcher("http://www,baidu.com").forward(request, response);
		//请求重定向,可以重定向到任何资源,正确的
		response.sendRedirect("http://www.baidu.com");
	}
}
