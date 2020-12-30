<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angle Recipe</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<h1>LOGIN</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" class="user_id" name="user_id" placeholder="ID" autofocus="autofocus"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input  type="password" class="user_pw" name="user_pw" placeholder="PW"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="LOGIN" onclick="loginPrc();">
			</td>
		</tr>
	</table>
<div>
	<a href="">Forget ID?</a>
	<a href="">Forget PW?</a>
</div>
<div>
	<input type="button" value="Join Us" onclick="location.href='signupform.do'">
</div>
<div id="naver_id_login">
	<a href=""><img width="210" src="resources/image/snslogin/네이버 아이디로 로그인_완성형_Green.PNG"></a>
</div>
</body>
</html>