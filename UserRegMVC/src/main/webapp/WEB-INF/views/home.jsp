<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h5><a href="<spring:url value='/user/register'/>">Register User</a></h5>
<h5><a href="<spring:url value='/user/login'/>">User Login</a></h5>
</body>
</html>
