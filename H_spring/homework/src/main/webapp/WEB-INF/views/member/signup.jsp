<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="/WEB-INF/views/include/head.jsp" %>



<%--signup 페이지에서만 사용할 head태그 --%>
<head>
   <style type="text/css">
      .valid_info{
         display:block; 
         color:red;
         font-size: 0.5vw;
      }
   </style>
</head>



<body>

 <%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>회원 가입 양식</h1>
	<!-- action => 요청 url -->
    <form action="${context}/member/signup" method="post" id="frmJoin" modelAttribute="signUpForm" >
     <table>
        <tr>
           <td>ID : </td>
           <td>
              <input type="text" name="userId" id="inpId" size="10"  required/>
              <button type="button" id ="btnIdCheck">중복확인 </button>
              <span class="valid_info" id="idCheck"> </span>
              <form:errors path="userId" />
           </td>
        </tr>
        <tr>
           <td>PASSWORD : </td>
           <td>
                <input type="password" name="password" id="pw" required/>
                <span id="pwConfirm" class="valid_info">
                <c:if test="${not empty param.passwordError}">
           	  		${param.passwordError}
           	  	</c:if>  
                </span>
           </td>
        </tr>
        <tr>
           <td>휴대폰번호 : </td>
           <td>
                <input type="tel" name="tell" required/>
           </td>
        </tr>
        <tr>
           <td>email : </td>
           <td>
                <input type="email" name="email" required/>
           </td>
        </tr>
        <tr>
           <td>
              <input type="submit" value="가입" />
              <input type="reset" value="취소" />
           </td>
       </tr>
   </table>
   </form>
 
   <script type="text/javascript">
   			
   
  	let idCheckFlg = false;
      
   	btnIdCheck.addEventListener("click", ev => {
   		
   		let userId = inpId.value;
   		
   		if(userId){
   			fetch("/member/checkId?userId="+userId)
   			.then(response => response.json())
   			.then(obj => {
   				if(obj.exist){
   					idCheck.innerHTML = "이미 존재하는 아이디";
   					idCheckFlg = false;
   					return;
   				}
   				idCheck.innerHTML = "사용 가능한 아이디 입니다.";
   				idCheckFlg = true;
   				
   			});
   			
   		}

   		
   		
   	})
   	
   	frmJoin.addEventListener("submit", ev => {
   		console.dir(1);
   		
   		if(!idCheckFlg){
   			ev.preventDefault();
   	   		alert("아이디 중복 검사에 실패했습니다.");
   	   		inpId.focus();
   		}
   		
   	})
   	
   	
   
   
   
   
   </script>






































  <%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>