package com.emp.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dao.EmployeeDao;
import com.emp.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();
	
	public List<Employee> selectEmployeeAll(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Employee> employees = dao.selectEmployeeAll(session, cPage, numPerpage);
		session.close();
		
		return employees;
	}
	
	public int selectEmployeeCount() {
		SqlSession session = getSession();
		int result = dao.selectEmployeeCount(session);
		session.close();
		
		return result;
	}
	
	public List<Employee> searchEmp(Map<String, Object> param){
		SqlSession session = getSession();
		List<Employee> employees = dao.searchEmp(session, param);
		session.close();
		
		return employees;
	}
}
