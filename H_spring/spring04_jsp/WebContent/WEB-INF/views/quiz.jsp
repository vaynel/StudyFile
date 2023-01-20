<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1부터 사용자가 입력한 값까지 숫자들을 span태그로 만들어 출력해보자</h1>

<% 
	int num = (int)request.getAttribute("num");
	
	for(int i=1; i<=num;i++){
		
		out.print("<span>"+i+"</span>");
	}
	
	
%>

<h1>1부터 사용자가 입력한 값이 짝수인지 홀수인지 판단해보자</h1>


</body>
</html>