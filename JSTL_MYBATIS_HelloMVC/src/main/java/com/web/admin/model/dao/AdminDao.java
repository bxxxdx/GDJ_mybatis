package com.web.admin.model.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.web.member.model.vo.Member;

public class AdminDao {
	private static AdminDao adminDao;
	private AdminDao() {}
	public static AdminDao getAdminDao() {
		if(adminDao==null) adminDao = new AdminDao();
		return adminDao;
	}
		
	public List<Member> selectMemberList(SqlSession session, int cPage, int numPerpage){
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("admin.selectMemberList", null, rb);
	}
	
	public int selectMemberCount(SqlSession session) {
		return session.selectOne("admin.selectMemberCount");
	}
	
	public List<Member> selectSearchMemberList(SqlSession session, Map param, int cPage, int numPerpage){
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("admin.selectSearchMemberList", param, rb);
	}
	
	public int selectSearchMemberCount(SqlSession session, Map param) {
		return session.selectOne("admin.selectSearchMemberCount", param);
	}
	 
}
