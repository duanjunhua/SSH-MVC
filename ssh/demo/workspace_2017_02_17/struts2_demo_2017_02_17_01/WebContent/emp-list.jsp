<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form action="emp-save">
		<s:textfield name="firstName" label="FistName"></s:textfield>
		<s:textfield name="lastName" label="LastName"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	<br>
	<hr>
	<br>
	<table cellpadding="2" border="1" cellspacing="0">
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.employees">
				<tr>
					<td>${employeeId}</td>
					<td>${firstName}</td>
					<td>${lastName}</td>
					<td>${email}</td>
					<td><a href="emp-edit?employeeId=${employeeId}">Update</a></td>
					<td><a href="emp-delete?employeeId=${employeeId}">Delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>