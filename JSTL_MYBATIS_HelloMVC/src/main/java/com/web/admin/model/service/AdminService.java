package com.web.admin.model.service;

import static com.web.common.SessionTemplate.getSession;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.web.admin.model.dao.AdminDao;
import com.web.member.model.vo.Member;

public class AdminService {
	private static AdminService adminService;
	private AdminService() {}
	public static AdminService getAdminService() {
		if(adminService==null) adminService = new AdminService();
		return adminService;
	}
	
	public List<Member> selectMemberList(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Member> members = AdminDao.getAdminDao().selectMemberList(session, cPage, numPerpage);
		session.close();
		
		return members;
	}
	
	public int selectMemberCount() {
		SqlSession session = getSession();
		int result = AdminDao.getAdminDao().selectMemberCount(session);
		session.close();
		
		return result;
	}
	
	public List<Member> selectSearchMemberList(Map param, int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Member> members = AdminDao.getAdminDao().selectSearchMemberList(session, param, cPage, numPerpage);
		session.close();
		
		return members;
	}
	
	public int selectSearchMemberCount(Map param) {
		SqlSession session = getSession();
		int result = AdminDao.getAdminDao().selectSearchMemberCount(session, param);
		session.close();
		
		return result;
	}

}
