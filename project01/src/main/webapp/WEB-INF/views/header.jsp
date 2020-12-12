<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<link href="resources/css/header.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/3049a69bf8.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img src="resources/image/LOGO.svg" onclick="location.href='main.do'">
		</div>
			<div class="header_left">
				<ul id="mypage">
			<c:choose>
				<c:when test="${login != null }">
					<li><a href="logout.do" class="logout">LOGOUT</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="loginform.do">LOGIN</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${login.user_role == 'ADMIN' }">
					<li><a href="">ADMIN PAGE</a></li>
					<li><i class="far fa-bell alarm"></i></li>
				</c:when>
				<c:otherwise>
					<li><a href="">MY PAGE</a>
						<ul id="sub-menu">
							<li><a href="#">주문조회</a></li>
							<li><a href="#">찜한상품</a></li>
							<li><a href="#">게시판</a></li>
							<li><a href="#">회원정보</a></li>
						</ul>
					</li>
				</c:otherwise>
			</c:choose>
				</ul>
			</div>
			<div class="header_right">
				<a href="noticeform.do">NOTICE</a>
				<input type="text" class="search" placeholder="search.."/>
				<i class="fas fa-shopping-cart"></i>
			</div>
	</div>
</body>
</html>