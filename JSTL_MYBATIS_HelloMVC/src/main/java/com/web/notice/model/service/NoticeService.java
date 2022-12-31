package com.web.notice.model.service;

import static com.web.common.SessionTemplate.getSession;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.web.notice.model.dao.NoticeDao;
import com.web.notice.model.vo.Notice;

public class NoticeService {
	private static NoticeService noticeService;
	private NoticeService() {}
	public static NoticeService getNoticeService() {
		if(noticeService == null) noticeService = new NoticeService();
		return noticeService;
	}
	
	public int selectNoticeCount() {
		SqlSession session = getSession();
		int result = NoticeDao.getNoticeDao().selectNoticeCount(session);
		session.close();
		
		return result;
	}
	
	public List<Notice> searchNoticeAll(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Notice> list = NoticeDao.getNoticeDao().searchNoticeAll(session, cPage, numPerpage);
		session.close();
	
		return list;
	}
	
	public int insertNotice(Map param) {
		SqlSession session = getSession();
		int result = NoticeDao.getNoticeDao().insertNotice(session, param);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public Notice searchNoticeNo(int noticeNo) {
		SqlSession session = getSession();
		Notice n = NoticeDao.getNoticeDao().searchNoticeNo(session, noticeNo);
		session.close();
		
		return n;
	}
	
	public int updateNotice(Map param) {
		SqlSession session = getSession();
		int result = NoticeDao.getNoticeDao().updateNotice(session, param);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}	
	
	public int deleteNotice(int noticeNo) {
		SqlSession session = getSession();
		int result = NoticeDao.getNoticeDao().deleteNotice(session, noticeNo);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
}
