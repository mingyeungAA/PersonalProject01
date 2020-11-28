<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="resources/css/signup.css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/signup.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<h3>SIGN UP</h3>
	<table>
		<tr>
			<th>아이디 </th>
			<td>
				<input type="text" class="user_id" name="user_id" required="required">
				<span class="id_text">아이디를 입력해주세요.(영문소문자/숫자, 6~12자)</span>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" class="user_pw" name="user_pw" required="required">
				<span class="password_text">(영문 대소문자/숫자/특수문자 중 3가지 이상 조합, 8~16자)</span>
			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>
				<input type="password" class="user_pw_check" required="required">
				<span class="password_check_text"></span>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" class="user_name" name="user_name" required="required">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="email" class="user_email" name="user_email" required="required">
				<span class="email_text"></span>
			</td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><input type="tel" class="user_phone" name="user_phone" required="required"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" id="postcode" placeholder="우편번호" required="required">
				<input type="button" value="우편번호" onclick="exePostCode();">
				<br>
				<input type="text" id="address" placeholder="주소" required="required">
				<br>
				<input type="text" id="detailAddress" placeholder="나머지 주소" required="required">
			</td>
		</tr>
	</table>
	<div><input class="submit_btn" type="button" value="회원가입"></div>
</body>
</html>