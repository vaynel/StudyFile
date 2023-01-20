package com.mc.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mc.jsp.dto.Student;

/**
 * Servlet implementation class B_EL
 */
@WebServlet("/el")
public class B_EL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B_EL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		request.getRequestDispatcher("/WEB-INF/views/el-jstl/el-form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청파리미터로 넘어온 데이터를 파싱
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int math = Integer.parseInt(request.getParameter("math"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int coding = Integer.parseInt(request.getParameter("coding"));
		
		// 사용자에게 총점, 평균을 알려주자.
		int sum = kor + math + eng + coding;
		double avg = sum/4;
		
		// jsp로 전달될 request객체에 연산을 마친 합계, 평균 값을 저장
		request.setAttribute("sum", sum);
		request.setAttribute("avg", avg);
		request.setAttribute("user", name);
		
		// request에 자바빈 규약을 따르는 객체를 전달
		Student std = new Student();
		std.setName(name);
		std.setKor(kor);
		std.setEng(eng);
		std.setMath(math);
		std.setCoding(coding);
		request.setAttribute("std", std);
		
		List<Student> students = new ArrayList<Student>();
		students.add(std);
		request.setAttribute("students", students);
		
		List objs = new ArrayList<>();
		objs.add(std);
		request.setAttribute("objs", objs);
		
		// Session에 데이터를 저장하고 el에서 꺼내쓰기 
		HttpSession session = request.getSession();
		request.getSession().setAttribute("session","세션에 담긴 값입니다.");
		request.getSession().setAttribute("std", "request객체와 동일한 속성명에 저장된 값입니다.");
		
		//로그인할때 한거 데려와서함
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/el-jstl/el.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}

}

