package com.web.member.model.dao;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.web.member.model.vo.Member;

public class MemberDao {
	private static MemberDao memberDao;
	private MemberDao() {}
	public static MemberDao getMemberDao() {
		if(memberDao==null) memberDao = new MemberDao();
		return memberDao;
	}

	public Member searchMemberLogin(SqlSession session, Map param) {
		return session.selectOne("member.searchMemberLogin", param);
	}
	
	public Member searchMemberId(SqlSession session, String userId) {
		return session.selectOne("member.searchMemberId", userId);
	}
	
	public int insertMember(SqlSession session, Map param) {
		return session.insert("member.insertMember", param);
	}
	
	public int updateMember(SqlSession session, Map param) {
		return session.update("updateMember", param);
	}
	
	public int deleteMember(SqlSession session, String userId) {
		return session.delete("deleteMember", userId);
	}
	
	public int updatePassword(SqlSession session, Map param) {
		return session.update("updatePassword", param);
	}
	
}
