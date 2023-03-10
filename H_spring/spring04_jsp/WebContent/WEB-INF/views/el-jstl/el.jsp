<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>EL 표현식</h1>
	<%--
		el표기법 : 자바 bean 객체의 속성을 편하게 사용하기 위해 제공되는 표현식
		
		${} : 객체 프로퍼티에서 값을 꺼낼 때 사용.
		#{} : 객체 프로퍼티에 값을 넣을 때 사용.
		
		
		el표현식에서 제공되는 reference
		
		requestScope : request 객체의 attribute에 저장된 값에 접근
		sessionScope : session 객체의 attribute에 저장된 값에 접근
		applicationScope : servletContext 객체의 attribute에 저장된 값에 접근
		param 		: request의 요청파라미터에 접근
		paramValues : 같은 이름의 요청파라미터에 값이 여러개 있을 경우 배열로 요청파라미터값을 받아올 수 있다.
		cookie		: request의 Cookie에 접근		
		
		만약 requestScope, sessionScope, applicationScope를 지정하여 스코프를 명시하지 않을 경우
		page 스코프부터 속성값을 탐색한다.
	
	 --%>
	 
	 <h2>EL 사용하기</h2>
	 <span>이름 : ${user}</span>
	 <span>합계 : ${sum}</span>
	 <span>평균 : ${avg}</span>

	<hr>

	<h2>EL을 사용해 DTO에서 데이터 꺼내쓰기</h2>
	<pre>
		DTO의 속성명을 사용해 값을 꺼낼 수 있다.
		내부적으로 getter 를 호출한다.
	</pre>
	<span>이름 : ${std.name}</span>
	<span>국어 : ${std.kor}</span>
	<span>수학 : ${std.math}</span>
	<span>영어 : ${std.eng}</span>
	<span>코딩 : ${std.coding}</span>
	<span>합계 : ${std.sum}</span>
	<span>평균 : ${std.avg}</span>
	
	
	<h2>EL을 사용해 List에서 데이터를 꺼내쓰기</h2>
	<span>이름 : ${students[0].name}</span>
	<span>국어 : ${students[0].kor}</span>
	<span>수학 : ${students[0].math}</span>
	<span>영어 : ${students[0].eng}</span>
	<span>코딩 : ${students[0].coding}</span>
	<span>합계 : ${students[0].sum}</span>
	<span>평균 : ${students[0].avg}</span>
	
	<h2>리스트에 dto나 map에 dto를 반기</h2>
	<span>이름 : ${objs[0].name}</span>
	<span>국어 : ${objs[0].kor}</span>
	<span>수학 : ${objs[0].math}</span>
	<span>영어 : ${objs[0].eng}</span>
	<span>코딩 : ${objs[0].coding}</span>
	<span>합계 : ${objs[0].sum}</span>
	<span>평균 : ${objs[0].avg}</span>

	
	<h2>Sessin에 담긴 데이터에 접근</h2>
	<span>${session}</span>
	<pre>std 속성을 호출하면 현재 스코프인 PageScrope에 가까운 RequestScope에 담긴 속성이 반환된다.
		sessionScope 래퍼런스를 앞에 붙여 스코프를 명시해주면 HttpSession 객체에 담긴 데이터를 반환 받을 수 있다.
	</pre>
	<span>${sessionScope.std}</span>
	
	<h2>Cookie에 접근</h2>
	<span>JSESSIONID : ${cookie.JSESSIONID.value }</span>
	
	<h2>EL literal</h2>
	<span>문자열 : ${"문자열 테스트" }</span>
	<span>문자열 : ${'"문자열 테스트"'}</span>	
	<span>숫자 : ${100}</span>	
	
	 
	<h2>EL 연산자</h2>
	<pre>empty연산자</pre>
	<span>empty null : ${empty null}</span>
	<span>empty "" : ${empty ""}</span>
	<span>empty objs : ${empty objs}</span>
	 
	<h2>프로퍼티 값 변경</h2>
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>