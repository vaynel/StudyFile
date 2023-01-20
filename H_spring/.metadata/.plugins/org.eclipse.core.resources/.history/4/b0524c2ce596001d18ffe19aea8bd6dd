package com.mc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B_Response
 */
@WebServlet("/res")
public class B_Response extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_Response() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      //response.getWriter를 통해 응답 body에 워하는 데이터를 작성할 수 있다.
      PrintWriter pw = response.getWriter();
      pw.println("<h1>getWriter : response body에 문자 데이터 작성 </h1>");
      pw.println("<h1>getOutputStream : response body에 바이너리 데이터 작성 </h1>");
      pw.println("<h1>sendRedirect : 응답상태코드 302 반환 </h1>");
   
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}