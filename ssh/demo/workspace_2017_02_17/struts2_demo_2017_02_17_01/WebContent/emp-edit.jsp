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
		<s:debug></s:debug>
		<br>
		<hr>
		<br>
		<s:form action="emp-update">
		<s:hidden name="employeeId"></s:hidden>
		<s:textfield name="firstName" label="FistName">${firstName }</s:textfield>
		<s:textfield name="lastName" label="LastName"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:submit value="Update"></s:submit>
	</s:form>
</body>
</html>