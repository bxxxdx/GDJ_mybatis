package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

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
	
	public int updateStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudent(session, s);
		if(result > 0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int selectStudentCount() {
		SqlSession session = getSession();
		int result = dao.selectStudentCount(session);;
		session.close();
		
		return result;
	}
	
	public Student selectStudent(int no) {
		SqlSession session = getSession();
		Student s = dao.selectStudent(session, no);
		session.close();
		
		return s;
	}
	
	public List<Student> selectStudentAll(){
		SqlSession session = getSession();
		List<Student> students = dao.selectStudentAll(session);
		session.close();
		
		return students;
	}
	
	
	public List<Student> selectStudentName(String name){
		SqlSession session = getSession();
		List<Student> students = dao.selectStudentName(session, name);
		session.close();
		
		return students;
	}
	
	public Map selectStudentMap(int no) {
		SqlSession session = getSession();
		Map student = dao.selectStudentMap(session, no);
		session.close();
		
		return student;
	}
	
	public List<Map> selectStudentAllMap(){
		SqlSession session = getSession();
		List<Map> students = dao.selectStudentAllMap(session);
		session.close();
		
		return students;
	}
	
	public List<Student> selectPageList(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Student> students = dao.selectPageList(session, cPage, numPerpage);
		session.close();
		
		return students;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
