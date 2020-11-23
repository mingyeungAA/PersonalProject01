<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<form action="login.do">
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
				<input type="submit" value="LOGIN">
			</td>
		</tr>
	</table>
</form>
<div>
	<a href="">Forget ID?</a>
	<a href="">Forget PW?</a>
</div>
<div>
	<input type="button" value="Sign Up">
</div>
</body>
</html>