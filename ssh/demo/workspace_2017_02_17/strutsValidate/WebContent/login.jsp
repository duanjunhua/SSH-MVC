<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="testValidate">
		<s:textfield name="age" label="Age"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:password name="password" label="PassWord"></s:password>
		<s:password name="confirmpwd" label="Confirm PassWord"></s:password> <s:actionerror/> <!-- 显示错误消息 -->
		<s:submit></s:submit>
	</s:form>
</body>
</html>