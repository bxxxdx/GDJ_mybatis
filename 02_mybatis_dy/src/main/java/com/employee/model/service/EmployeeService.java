package com.employee.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.employee.model.dao.EmployeeDao;
import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;

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
	
	public Department selectDept(String deptId) {
		SqlSession session = getSession();
		Department d = dao.selectDept(session, deptId);
		session.close();
		
		return d;
	}
}
