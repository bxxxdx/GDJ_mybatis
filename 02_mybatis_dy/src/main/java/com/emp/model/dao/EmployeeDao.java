package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.emp.model.vo.Employee;

public class EmployeeDao {
	
	public List<Employee> selectEmployeeAll(SqlSession session, int cPage, int numPerpage){
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("employee.selectEmployeeAll", null, rb);
	}
	
	public int selectEmployeeCount(SqlSession session) {
		return session.selectOne("employee.selectEmployeeCount");
	}
	
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param){
		return session.selectList("employee.searchEmp",param);
	}
}
