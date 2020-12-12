<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<link href="resources/css/notice_detail.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Notice Detail</h1>
	<table>
		<tr>
			<th>제목</th>
			<td>${dto.notice_title }</td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.notice_writer }</td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td class="date">${dto.notice_regdate }</td>
			<th class="view">조회수</th>
			<td>${dto.notice_viewer }</td>
		</tr>
		<tr>
			<th></th>
			<td colspan="4">
				${dto.notice_content }
			</td>
		</tr>
	</table>
	<div class="input__area">
	<c:choose>
		<c:when test="${login.user_role eq 'ADMIN' }">
			<input type="button" value="목록" onclick="location.href='noticeform.do'">		
			<input type="button" value="글수정" onclick="location.href='noticeupdate.do?notice_no=${dto.notice_no}'">
			<input type="button" value="삭제" onclick="location.href='noticedelete.do?notice_no=${dto.notice_no}'">
		</c:when>
		<c:otherwise>
			<input type="button" value="목록" onclick="location.href='noticeform.do'">
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>