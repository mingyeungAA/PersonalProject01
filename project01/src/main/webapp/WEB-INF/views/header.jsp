<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<link href="resources/css/header.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<span onclick="location.href='main.do'" class="logo"><img src="resources/image/LOGO.svg"></span>
			<ul id="mypage">
				<li><a href="">MY PAGE</a>
					<ul id="sub-menu">
						<li><a href="#">주문조회</a></li>
						<li><a href="#">찜한상품</a></li>
						<li><a href="#">게시판</a></li>
						<li><a href="#">회원정보</a></li>
					</ul>
				</li>
		<c:choose>
			<c:when test="${login != null }">
				<li><a href="logout.do" class="logout">logout</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="loginform.do">login</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
</body>
</html>