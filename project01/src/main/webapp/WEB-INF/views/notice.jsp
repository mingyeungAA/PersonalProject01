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
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Notice</h1>
		<table>
		<col width="50">
		<col width="300">
		<col width="20">
		<col width="40">
		<col width="20">  
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
							<td style="text-align: left"><a href="">${dto.notice_title }</a></td>
							<td>${dto.notice_writer }</td>
							<td>${dto.notice_regdate }</td>
							<td>${dto.notice_viewer }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
</body>
</html>