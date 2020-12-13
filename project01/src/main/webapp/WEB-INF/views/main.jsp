<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Angle Recipe</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="resources/js/main.js"></script>
<link href="resources/css/main.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div class="item__box">
	<ul class="item__detail">
	<c:choose>
		<c:when test="${empty list }">
			<li><p>---상품이 없습니다.---</p></li>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto">
			<li>
				<div><img class="item__image" src="resources/image/item/${dto.item_photo }"></div>
				<div class="item__description">
					<div class="item__color">
						<span class="chips ivory__color"></span>
						<span class="chips baige__color"></span>
						<span class="chips yellow__color"></span>
						<span class="chips pink__color"></span>
					</div>
					<strong>${dto.item_name }</strong>
					<ul class="item__content__box">
						<li><span class="item__content">${dto.item_content }</span></li>
					</ul>
				</div>
			</li>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</ul>
	</div>
</body>
</html>