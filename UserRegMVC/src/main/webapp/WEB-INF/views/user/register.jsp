<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>${requestScope.mesg}</h3>
	<form style="background: aqua;" method="post">
		Enter the username: <input type="text" name="username">
		Enter the email: <input type="email" name="useremail" >
		Enter the password: <input type="password" name="userpassword">
		<input type="submit" value="Submit"/>
	</form>
	<h4><a href="<spring:url value='/user/login'/>">Login</a></h4>
</body>
</html>