<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid blue;
	}
</style>
</head>
<body>
	<center>
		<h3>Query result</h3>
		<table>
			<tr>
				<th>flow_id</th>
				<th>my_type</th>
				<th>id_card</th>
				<th>exam_card</th>
				<th>student_name</th>
				<th>location</th>
				<th>grade</th>
			</tr>
			<c_rt:forEach var="stu" items="${students}">
				<tr>
					<td>${stu.flowId}</td>
					<td>${stu.myType }</td>
					<td>${stu.idCard }</td>
					<td>${stu.examCard }</td>
					<td>${stu.studentName }</td>
					<td>${stu.location }</td>
					<td>${stu.grade }</td>
				</tr>
			</c_rt:forEach>
		</table>
	</center>
</body>
</html>