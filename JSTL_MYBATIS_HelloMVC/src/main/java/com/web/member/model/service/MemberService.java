package com.web.member.model.service;


import static com.web.common.SessionTemplate.getSession;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.web.member.model.dao.MemberDao;
import com.web.member.model.vo.Member;

public class MemberService {
	private static MemberService memberService;
	private MemberService() {}
	public static MemberService getMemberService() {
		if(memberService==null) memberService = new MemberService();
		return memberService;
	}
	
	public Member searchMemberLogin(Map param) {
		SqlSession session = getSession();
		Member result = MemberDao.getMemberDao().searchMemberLogin(session, param);
		session.close();
		
		return result;
	}
	
	public Member searchMemberId(String id) {	
		SqlSession session = getSession();
		Member result = MemberDao.getMemberDao().searchMemberId(session, id);
		session.close();
		
		return result;
	}
	
	public int insertMember(Map param) {
		SqlSession session = getSession();		
		int result = MemberDao.getMemberDao().insertMember(session, param); 
		
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int updateMember(Map param) {
		SqlSession session = getSession();		
		int result = MemberDao.getMemberDao().updateMember(session, param);
		
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int deleteMember(String userId) {
		SqlSession session = getSession();		
		int result = MemberDao.getMemberDao().deleteMember(session, userId);
		
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int updatePassword(Map param) {
		SqlSession session = getSession();		
		int result = MemberDao.getMemberDao().updatePassword(session, param);
		
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
}
