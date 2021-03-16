<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h3>${status}</h3>
	<h2 style="color: red;">${requestScope.loginStatus}</h2>
	<form style="background: aqua;" method="post">
		Enter the email: <input type="email" name="useremail" >
		Enter the password: <input type="password" name="userpassword">
		<input type="submit" value="Submit"/>
	</form>
	<h4><a href="<spring:url value='/user/register'/>">Register</a></h4>
</body>
</html>