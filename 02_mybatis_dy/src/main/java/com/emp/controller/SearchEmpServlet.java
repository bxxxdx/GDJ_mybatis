package com.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.service.EmployeeService;
import com.emp.model.vo.Employee;

/**
 * Servlet implementation class SearchEmpServlet
 */
@WebServlet("/searchEmp.do")
public class SearchEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String type = request.getParameter("type");
		//String keyword = request.getParameter("keyword");
		request.setCharacterEncoding("UTF-8");
		
		Map<String, Object> param = new HashMap();
		
		param.put("type", request.getParameter("type"));
		param.put("keyword", request.getParameter("keyword"));
		param.put("gender", request.getParameter("gender"));
		
		List<Employee> employees = new EmployeeService().searchEmp(param);
		
		employees.stream().forEach(v->System.out.println(v));
		
		request.setAttribute("employees", employees);
		
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
