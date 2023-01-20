package com.mc.servlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A_Request
 */
@WebServlet("/req")
public class A_Request extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_Request() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      System.out.println("doGet 메서드 호출");
      
      String name = request.getParameter("name");
      int age = Integer.parseInt(request.getParameter("age"));
      System.out.println(name + " : " + age);
      
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      System.out.println("doPost 메서드 호출");
      request.setCharacterEncoding("utf-8");
      
      String name = request.getParameter("name");
      int age = Integer.parseInt(request.getParameter("age"));
      
      System.out.println(name + " : " + age);
      System.out.println(request.getContentType());
      
      
      /////////////////////////////////////////////////////
      
      if(request.getContentType().startsWith("multipart/form-data")) {
         getHttpMessage(request);
      }
      
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   private void getHttpMessage(HttpServletRequest request) {
      
      InputStream is = null;
      OutputStream os = null;
      try {
         
         is = request.getInputStream();
         os = new FileOutputStream("C:\\Program files\\CODE\\httpmessage.txt");
         int b = 0;
         while((b=is.read()) != -1) {
            os.write(b);
         }
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            is.close();
            os.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

}