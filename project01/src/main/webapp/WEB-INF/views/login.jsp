<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
<h1>Login Form</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" class="user_id" name="user_id" placeholder="ID"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input  type="password" class="user_pw" name="user_pw" placeholder="PW"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="LOGIN" onclick="login();">
			</td>
		</tr>
	</table>
<div>
	<a href="">Forget ID?</a>
	<a href="">Forget PW?</a>
</div>
<div>
	<input type="button" value="Sign Up">
</div>
</body>
</html>