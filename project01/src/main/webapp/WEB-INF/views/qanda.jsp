<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/qa.js"></script>
<link href="resources/css/qa.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Q&A</h1>
	<table>
	<col width="50">
	<col width="300">
	<col width="100">
	<col width="100">
		<tr>
			<th>NO</th>
			<th>SUBJECT</th>
			<th>NAME</th>
			<th>DATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th>---작성된 글이 없습니다.---</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td class="table__data">${dto.qa_no }</td>
						<td style="text-align: left">${dto.qa_title }</td>
						<td class="table__data">${dto.user_name }</td>
						<td class="table__data">${dto.qa_regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="location.href='QandAInsert.do'">
			</td>
		</tr>
	</table>
</body>
</html>