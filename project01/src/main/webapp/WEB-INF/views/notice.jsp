<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angel Recipe</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="resources/css/notice.css" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function(){
	<c:if test="${search_text == null}">
		$("#searchpaging").css("display", "none");
		$("#paging").css("display", "block");
	</c:if>
	<c:if test="${search_text != null}">
		$("#searchpaging").css("display", "block");
		$("#paging").css("display", "none");
	</c:if>
	
});
</script>
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
							<td style="text-align: left"><a href="noticedetail.do?notice_no=${dto.notice_no }" class="godetail">${dto.notice_title }</a></td>
							<td>${dto.notice_writer }</td>
							<td>${dto.notice_regdate }</td>
							<td>${dto.notice_viewer }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${login.user_role eq 'ADMIN' }">
			<div class="insert">
				<input type="button" value="글쓰기" onclick="location.href='noticeinsert.do'">
			</div>
		</c:if>
		<div class="search__area">
			<form action="searchnotice.do" method="post">
				<div class="search__type">
					<select name="searchType">
						<option value="notice_title">제목</option>
						<option value="notice_content">내용</option>
					</select>
				</div>
				<input type="text" class="search_bar" name="search_text">
				<button type="submit" class="search_btn"><i class="fas fa-search"></i></button>
			</form>
		</div>
		
	<!-- search 후 페이징 -->
	<div class="pagingdesign">
		<nav aria-label="Page navigation" class="pagingbox">
			<ul style="display:flex; text-align:center;" id="searchpaging" class="pagination">
				<li>
					<c:if test="${paging.startpage != 1}">
						<a href="searchnotice.do?nowpage=${paging.startpage-1}&cntPerpage=${paging.cntPerpage}&searchType=${searchType }&search_text=${search_text}" aria-label="Previous" class="pagingarrow">
								<span aria-hidden="true"><i class="fas fa-angle-double-left" style="color: black"></i></span>
							</a>
					</c:if>
					<c:forEach begin="${paging.startpage}" end="${paging.endpage}" var="p">
						<!-- when은 choose안에 꼭 들어가 있어야 한다. choose안에 otherwise는 없어도 된다. -->
						<c:choose>
							<c:when test="${p == paging.nowpage}">
								<a href="searchnotice.do?nowpage=${p}&cntPerpage=${paging.cntPerpage}&searchType=${searchType }&search_text=${search_text}" class="active pagingtext">${p}</a>
							</c:when>
							<c:when test="${p != paging.nowpage}">
								<a href="searchnotice.do?nowpage=${p}&cntPerpage=${paging.cntPerpage}&searchType=${searchType }&search_text=${search_text}" class="pagingtext">${p}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endpage != paging.lastpage}">
						<a href="searchnotice.do?nowpage=${paging.endpage+1}&cntPerpage=${paging.cntPerpage}&searchType=${searchType }&search_text=${search_text}" aria-label="Next" class="pagingarrow">
							<span aria-hidden="true"><i class="fas fa-angle-double-right" style="color: black"></i></span>
						</a>
					</c:if>
				</li>
			</ul>
		</nav>
	</div>
	
	<!-- !페이징 부분! -->
	<div class="pagingdesign">
		<nav aria-label="Page navigation" class="pagingbox">
			<ul style="display:flex; text-align:center;" id="paging" class="pagination">
				<li>
					<c:if test="${paging.startpage != 1}">
						<a href="noticeform.do?nowpage=${paging.startpage-1}&cntPerpage=${paging.cntPerpage}" aria-label="Previous" class="pagingarrow">
							<span aria-hidden="true"><i class="fas fa-angle-double-left" style="color: black"></i></span>
						</a>
					</c:if>
					<c:forEach begin="${paging.startpage}" end="${paging.endpage}" var="p">
						<!-- when은 choose안에 꼭 들어가 있어야 한다. choose안에 otherwise는 없어도 된다. -->
						<c:choose>
							<c:when test="${p == paging.nowpage}">
								<a href="noticeform.do?nowpage=${p}&cntPerpage=${paging.cntPerpage}" class="active pagingtext">${p}</a>
							</c:when>
							<c:when test="${p != paging.nowpage}">
								<a href="noticeform.do?nowpage=${p}&cntPerpage=${paging.cntPerpage}" class="pagingtext">${p}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endpage != paging.lastpage}">
						<a href="noticeform.do?nowpage=${paging.endpage+1}&cntPerpage=${paging.cntPerpage}" aria-label="Next" class="pagingarrow">
							<span aria-hidden="true"><i class="fas fa-angle-double-right" style="color: black"></i></span>
						</a>
					</c:if>
				</li>
				
			</ul>
		</nav>
	</div>
</div>
</body>
</html>