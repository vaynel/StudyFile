<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<link href="${context}/resources/css/todo/todo.css" rel="stylesheet">
<script src="${context}/resources/js/common.js"></script>
<script defer src="${context}/resources/js/todo/todo.js"></script>
<script defer src="${context}/resources/js/todo/weather-api.js"></script>
<script defer src="${context}/resources/js/todo/unsplash-api.js"></script>



<body>
	<%--<%@ include file="/WEB-INF/views/include/header.jsp"%> --%>

	<div class="weather row"></div>
	<div class="contents row">
		<div class="todo col">
			<div class="clock col">
				<div class="welcome">
					<span>Welcome 2023!</span>
				</div>
				<div class="time row">
					<span id="nowTime">14 : 05 : 00</span>
				</div>
			</div>
			<div class="user" id="userDiv"></div>
			<div class="wrap_inp col">
				<input type="text" class="inp" id="inp"
					placeholder="Type your name here">
					<div>${context }</div>
			</div>
		</div>
		<!-- todolist -->
		<ul class="todo-list row" id="todoList">

		</ul>
	</div>
	<div class="bg-location"></div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>