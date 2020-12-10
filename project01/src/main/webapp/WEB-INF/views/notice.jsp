<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<link href="resources/css/notice.css" rel="stylesheet">
</head>
<body>
<h1>Notice</h1>
	<table>
		<tr>
			<th>NO</th>
			<th>SUBJECT</th>
			<th>WRITER</th>
			<th>DATE</th>
			<th>HIT</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th>-----작성된 글이 없습니다.-----</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.notice_no }</td>
						<td>${dto.notice_title }</td>
						<td>${dto.notice_writer }</td>
						<td>${dto.notice_regdate }</td>
						<td>${dto.notice_viewer }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td></td>
		</tr>
	</table>
</body>
</html>