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
<script type="text/javascript" src="resources/js/qa_insert.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h1>Q&A Insert</h1>
	<table>
		<tr>
			<th>제목</th>
			<td>
				<select name="title_type">
					<option></option>
					<option></option>
					<option></option>
					<option></option>>
				</select>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td></td>
		</tr>
		<tr>
			<th></th>
			<td>
				<textarea id="summernote" name="qa_content"></textarea>
			</td>
		</tr>
	</table>
</body>
</html>