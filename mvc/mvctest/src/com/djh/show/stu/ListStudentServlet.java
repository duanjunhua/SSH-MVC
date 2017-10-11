package com.djh.show.stu;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djh.test.Student;
import com.djh.test.StudentDAO;
/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/ListStudentServlet")
public class ListStudentServlet extends HttpServlet {
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM students";
		try {
//			pStatement  = StudentDAO.getConnection().prepareStatement(sql);
			rSet  = StudentDAO.getResultSet(StudentDAO.getConnection(), sql);
			while(rSet.next()){
				int flowId = rSet.getInt(1);
				String myType = rSet.getString(2);
				String idCard = rSet.getString(3);
				String examCard = rSet.getString(4);
				String studentName = rSet.getString(5);
				String location = rSet.getString(6);
				int grade = rSet.getInt(7);
				Student stu = new Student(flowId, myType, idCard, examCard, studentName, location, grade);
				students.add(stu);
			}
			StudentDAO.releaseAll(null,pStatement, rSet);
			request.setAttribute("students", students);
			request.getRequestDispatcher("/show.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
