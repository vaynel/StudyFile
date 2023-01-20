package com.mc.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class D_Redirect
 */
@WebServlet("/cat/*")
public class D_Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String url = request.getRequestURI();
		String[] urlArr = url.split("/");
		System.out.println(Arrays.toString(urlArr));
		
		if(urlArr.length==3) {
			String type = request.getParameter("type");
			
			if(type.equals("name")) {
				response.sendRedirect("/spirng04_servlet/cat/name");
			}else {
				response.sendRedirect("/spring04_servlet/resources/image/image03.ipg");
			}
			return;
		}
		
		
		
		switch (urlArr[3]) {
		case "name":
			responseName(request,response);
			return;			
			//puppy/name, puppy/img가 아닌 puppy로 시작하는 다른 요청이 들어왔을 경우
		default: response.setStatus(404);
			break;
		}
		
		
		// C_Forward, D_Redirect
		// 요청의 재지정, 요청의 재요청
		
		// 요청의 재지정 : 클라이언트의 요청에 대해서 작업을 수행ㄴ되느 우리가 서버가 제공하는 다른 요청을 서버 내부에서 재지정
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	
	private void responseName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset = utf-8") ;
		String type = request.getParameter("type");
		response.getWriter().println("나비");
		System.out.println(type);
	}


}
