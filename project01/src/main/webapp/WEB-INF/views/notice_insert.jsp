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
<script type="text/javascript" src="resources/js/notice_insert.js"></script>
<link href="resources/css/notice_insert.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Notice Insert</h1>
	<form action="noticeinsertRes.do">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="notice_title" placeholder="제목 입력"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="notice_writer" placeholder="작성자 입력"></td>
			</tr>
			<tr>
				<th></th>
				<td>
					<textarea id="summernote" name="notice_content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="취소" onclick="location.href='noticeform.do'">
					<input type="submit" value="글등록">
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>