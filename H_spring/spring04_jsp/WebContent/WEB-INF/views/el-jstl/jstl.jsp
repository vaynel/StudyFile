<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span{
		display: block;
		font-size:1.5vw;
		color:red;
	}
</style>
</head>
<body>
<h1>JSTL</h1>
	<pre>
		JSP에서 사용하는 스크립틀릿의 복잡함을 해결하기 위해 사용는 지시자 
	</pre>
	<h2>1. c:set 변수 생성</h2>
	<pre>
		var: 변수명
		value : 값
	</pre>
	<c:set var="num1" value="100"></c:set>
	<c:set var="html" value="<a href='https://www.naver.com'>네이버로 이동 </a>"></c:set>
	<c:set var="context" value="${pageContext.request.contextPath}"></c:set>
	
	
	<h2>2. c:out 변수 출력</h2>
	<span><c:out value="${num1}"></c:out></span>
	<span><c:out value="${context}"></c:out></span>
	${html}
	
	
	
	<h2>3. jstl을 사용한 배열 생성</h2>
	<c:set var="jstlArr">
		red,blue,yellow,pink,green
	</c:set>
	<span>jstlArr : <c:out value="${jstlArr}"></c:out></span>
	
	<h2>4. jstl 조건문</h2>
	
	<h2>4. jstl 반복문</h2>
	<h3>forEach, for문처럼 사용하기</h3>
	<span>
		<c:forEach var="i" begin="0" end ="10" step="1">
			${i}
		</c:forEach>
	</span>
	
	<h3>forEach, forEach문처럼 사용하기</h3>
	
	
	<h2>c:forTokens, String.split()와 유사한 기능</h2>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>