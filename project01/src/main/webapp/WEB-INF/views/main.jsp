<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 onclick="location.href='main.do'"><img src="resources/image/LOGO.svg"></h1>
	<c:choose>
		<c:when test="${login != null }">
			<a href="logout.do">logout</a>
		</c:when>
		<c:otherwise>
			<a href="loginform.do">login</a>
		</c:otherwise>
	</c:choose>
</body>
</html>