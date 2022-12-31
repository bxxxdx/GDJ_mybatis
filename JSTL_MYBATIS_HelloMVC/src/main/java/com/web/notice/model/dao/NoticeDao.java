package com.web.notice.model.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.web.notice.model.vo.Notice;

public class NoticeDao {
	private static NoticeDao noticeDao;
	private NoticeDao() {}
	public static NoticeDao getNoticeDao() {
		if(noticeDao==null) noticeDao = new NoticeDao();
		return noticeDao;
	}
	
	public int selectNoticeCount(SqlSession session) {
		return session.selectOne("selectNoticeCount");
	}
	
	public List<Notice> searchNoticeAll(SqlSession session, int cPage, int numPerpage){
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("searchNoticeAll", null, rb);
	}
	
	public int insertNotice(SqlSession session, Map param) {
		return session.insert("notice.insertNotice", param);
	}
	
	public Notice searchNoticeNo(SqlSession session, int noticeNo) {
		return session.selectOne("notice.searchNoticeNo", noticeNo);
	}
	
	public int updateNotice(SqlSession session, Map param) {
		return session.update("notice.updateNotice", param);
	}
	
	public int deleteNotice(SqlSession session, int noticeNo) {
		return session.delete("notice.deleteNotice", noticeNo);
	}

}
