<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기초</h1>
	
	<h2><%= request.getAttribute("tit1") %></h2>
	<pre> 
	지시자 태그란, 페이지 전체에서 사용할 속성을 지정하는 jsp태그
	표현식 : &lt;%@  %&gt;
	
	1. page 지시자태그 : 해당 페이지에서 사용할 속성을 지정
		1-1 : language : 사용할 프로그래밍 언어
		1-2 : import   : 해당 jsp에서 사용할 다른 패키지를 import 할때 사용
	
	2. include 지시자태그 : 다른 위치의 jsp를 현재 jsp에 삽입할 때 사용
	3. taglib 지시자태그 : 다른 라이브러리에서 제공하는 커스텀태그를 사용할 때 사용
	
	
	</pre>
	
	<h2>선언 태그</h2>
	<pre>
		필드에 메서드나, 변수를 선언할 때 사용
		필드에 선언되기 때문에 조심해서 사용해야한다.
		필드에 선언된 변수는, 멀티쓰래드 환경에서 공유자원이 되기 때문에!
		표현식 : &lt;%!  %&gt;
	</pre>
	<%! String name = "mc";
		public void printName(){
			System.out.println(name);
		}
	
	%>
	
	<h2>스크립트릿 태그</h2>
	
	<pre>
		jsp내부에서 자바의 소스코드를 작성하는 영역
		스크립틀릿 내부에서 작성된 코드는 _jspSerice에서 작성됨
		
		_jspService 메서드에 선언되어 있는
		request, response, session, config(ServletConfig), application(ServletContext)
		
		Servlet의 life cycle
		
		Page Scope			: jsp의 pageContext 객체, jsp만에서만 생성되고 소명되는 객체
		Request Scope		: HttpServletRequest, HttpServletResponse, 요청이 오면생성되고 응답이 끝나면 소멸되는 객체
		Session Scope		: HttpSession, 브라우저 Session을 스코프로 가지는 객체
		Application Scope	: ServletContext 객체 
		
		
	</pre>
	
	<% printName();
		for(int i = 0; i <5; i++){
			System.out.println(i+"번째 스크립틀릿태그");
		}
		
	%>
	
	<h2>표현식 태그 </h2>
	<pre>
		out.print 메서드가 호출된다.
		표현식 : &lt;%=  %&gt;
	</pre>
	 <h3><%= name+", 2023년 1월 19일 정신 못차림" %></h3> 
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>