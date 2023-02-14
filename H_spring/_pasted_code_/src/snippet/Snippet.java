package snippet;

public class Snippet {
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
	<head>
		<link href="/resources/css/board/board.css" rel="stylesheet"> 
	</head>
	<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<div class="content container">   
	    <h2 class="tit">*�Խ���</h2>
	    <div class="desc_board">
	      <div class="info" >
	          <span>��ȣ : ${board.bdIdx}</span>
	          <span>���� : ${board.title}</span>
	          <span>����� : ${board.regDateAsDate}</span>
	          <span>�ۼ��� : ${board.userId}</span>
	      </div>
	      <div class="info file_info">
	      	<ol>
	      	<c:forEach var="file" items="${files}">
	      		<li>  
	      	 		<a href="/board/download?flIdx=${file.flIdx}">${file.originFileName}</a> 
	      	 	</li>	     
	      	</c:forEach>
	      	</ol>
	      </div>
	      <div class="article_content">
	      	<pre>${board.content}</pre>
	      </div>
	      <div class="btn_section">
	      
	          <button onclick="location.href='/board/list'"><span>���</span></button>
	          
	          <c:if test="${ not empty sessionScope.auth and board.userId == sessionScope.auth.userId }">
	          <form action="/board/remove" method="post">
	          	<input type="hidden" value="${board.bdIdx}" name="bdIdx"/> 
	          	<button id="btnDel"><span>����</span></button>
	          </form>
	          	
	          	<button id="btnModify"><span>����</span></button>
	          </c:if>
	          
	      </div>
	   </div>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
	
	</body>
	</html>
}

