<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div class="container">
       <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
         <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
           <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
         </a>
   
         <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
           <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
           <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
         </ul>
   
   
   		<c:if test="${empty sessionScope.auth}">
         <div class="col-md-3 text-end">

              <a href="/member/login" class="btn btn-outline-primary me-2">Login</a>
              <a href="/member/signup" class="btn btn-primary">Sign-up</a>

         </div>
         </c:if>
         
         <c:if test="${not empty sessionScope.auth}">
         <div class="col-md-3 text-end">

              <a class="btn btn-outline-primary me-2">${sessionScope.auth.userId }</a>
              <a href="/member/logout class="btn btn-primary">Logout</a>

         </div>
         </c:if>
         
       </header>
   </div>


</body>
</html>