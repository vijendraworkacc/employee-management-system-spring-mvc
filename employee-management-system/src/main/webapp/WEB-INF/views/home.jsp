<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%
	String empId = (String) request.getAttribute("empId");
	String empEmail = (String) request.getAttribute("empEmail");
	Integer empAge = (Integer) request.getAttribute("empAge");
	%>

	<h1>This is your HOME page!</h1>
	<h3>
		This is your employee ID:
		<%=empId%></h3>
	<h3>
		This is your email ID:
		<%=empEmail%></h3>
	<h3>
		This is your age:
		<%=empAge%></h3>
</body>
</html>