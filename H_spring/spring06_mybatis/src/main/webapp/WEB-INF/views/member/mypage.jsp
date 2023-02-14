<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<body>
<ul>
	<li>${member.userId}</li>
	<li>${dummy.userId}</li>
	<li>${member.password}</li>
	<li>${dum.password}</li>
	<li>${member.email}</li>
	


</ul>
<script type="text/javascript">
	console.dir(${member})
	console.dir(${dum})
	console.dir(1)

</script>



</body>
</html>