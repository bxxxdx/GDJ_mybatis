package com.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class StudentDao {
	
	public int insertStudent(SqlSession session) {
		//mybatis를 이용해서 sql구문을 실행할 때는
		//session객체가 제공하는 메소드를 이용해서 실행함.
		//실행될 sql구문은 mapper로 등록되어 있는 xml파일을 선택해서 실행.		
		return session.insert("student.insertStudent");
	}
	
	public int insertStudentName(SqlSession session, String name) {	
		return session.insert("student.insertStudentName", name);
	}
	
	public int insertStudentInput(SqlSession session, Student s) {
		return session.insert("student.insertStudentInput", s);
	}
	
	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent", s);
	}
	
	
	//데이터를 조회하는 메소드는 2가지로 구분
	//단일값 : 결과가 1행만 있는가? -> selectOne() 이용 - 한개 type(vo, int, String)
	//다중값 : 결과가 다수행인가? -> selectList() 메소드 이용 - List<T>
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	public Student selectStudent(SqlSession session, int no) {
		return session.selectOne("student.selectStudent", no);
	}
	
	public List<Student> selectStudentAll(SqlSession session){
		return session.selectList("student.selectStudentAll");
	}
	
	
	
	
	
	
	
	
	
	
}
