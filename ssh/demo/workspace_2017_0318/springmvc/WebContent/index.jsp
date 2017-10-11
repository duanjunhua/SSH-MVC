<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="test/testView">test View</a>
	<br>

	<form action="test/testModelAttribute" method="post">
		StudentId:<input type="text" name="id" value="1" />
		<br>
		StudentName:<input type="text" name="name" value="Michael" />
		<br>
		StudentAge:<input type="text" name="age" value="24" />
		<br>
		<input type="submit" value="submit" />
	</form>
	<br>
	<a href="test/requestMapping">test requestMapping</a>
	<br>
	<a href="test/helloworld">Hello World</a>
	<br>
	<a href="test/testModelAndView">TestModelAndView</a>
</body>
</html>