package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentPageServlet
 */
@WebServlet("/student/studentpage.do")
public class StudentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		int numPerpage=2;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage = 1;
		}
		
		List<Student> students = new StudentService().selectPageList(cPage, numPerpage);
		
		//students.stream().forEach(v->System.out.println(v));
		
		//페이지바를 만들어 보자..!!
		int totalData = new StudentService().selectStudentCount();
		int totalPage = (int)(Math.ceil((double)totalData/numPerpage));
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		
		String pageBar = "";
		if(pageNo==1) {
			pageBar += "<span>[이전]<span>";
		} else {
			pageBar += "<a href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"'>"+"[이전]"+"</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar += "<span>"+pageNo+"<span>";
			}
			else {
				pageBar += "<a href='"+request.getRequestURI()+"?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo > totalPage) {
			pageBar += "<span>[다음]<span>";
		} else {
			pageBar += "<a href='"+request.getRequestURI()+"?cPage="+(pageNo)+"'>"+"[다음]"+"</a>";
		}
		
		request.setAttribute("students", students);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/studentContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
