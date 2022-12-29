package com.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.service.EmployeeService;
import com.emp.model.vo.Employee;

/**
 * Servlet implementation class SelectEmployeeAll
 */
@WebServlet("/employee/selectEmployeeAll.do")
public class SelectEmployeeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEmployeeAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		int numPerpage=5;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage = 1;
		}

		List<Employee> employees = new EmployeeService().selectEmployeeAll(cPage, numPerpage);
	
		//페이지바를 만들어 보자..!!
		int totalData = new EmployeeService().selectEmployeeCount();
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
		
		//employees.stream().forEach(v->System.out.println(v));
		
		request.setAttribute("employees", employees);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/employee/employeeContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
