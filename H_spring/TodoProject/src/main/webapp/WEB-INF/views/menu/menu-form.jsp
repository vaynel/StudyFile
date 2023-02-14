<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>

	<hr>
	<h1>메뉴 주문 시스템</h1>
	<hr>
	 <h2>메뉴를 선택하세요</h2>
	<form action="${context}/menu/selectMenu" " method="post">
		<select name="menu" multiple style="width: 300px">
			<option value="Pizza" type="text">피자</option>
			<option value="Hamburger" type="text">햄버거</option>
			<option value="Chicken" type="text">치킨</option>
			<option value="Fish" type="text">회</option>
			<script type="text/javascript">

	     </script>
		</select>

		<button>전송</button>


	</form>

</body>
</html>