<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript" src="resources/js/notice_update.js"></script>
<link href="resources/css/notice_update.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Notice Update</h1>
	<form action="noticeupdateRes.do" method="post">
	<input type="hidden" name="notice_no" value=${dto.notice_no }>
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" value="${dto.notice_title }" name="notice_title"></td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" value="${dto.notice_writer }" name="notice_writer"></td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th></th>
			<td>
				<textarea id="summernote" name="notice_content">${dto.notice_content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="취소" onclick="location.href='noticedetail.do?notice_no=${dto.notice_no}'">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
	</form>
</html>