package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.vo.Student;

public class StudentService {
	private StudentDao dao = new StudentDao();
	
	public int insertStudent() {
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		if(result > 0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentName(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudentName(session, name);
		if(result > 0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int insertStudentInput(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudentInput(session, s);
		if(result > 0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
}
