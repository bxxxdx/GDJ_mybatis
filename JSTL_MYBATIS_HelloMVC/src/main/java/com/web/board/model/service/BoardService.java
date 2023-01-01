package com.web.board.model.service;

import static com.web.common.SessionTemplate.getSession;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.web.board.model.dao.BoardDao;
import com.web.board.model.vo.Board;

public class BoardService {
	private static BoardService boardService;
	private BoardService() {}
	public static BoardService getBoardService() {
		if(boardService == null) boardService = new BoardService();
		return boardService;
	}
	
	public List<Board> searchBoardAll(int cPage, int numPerpage){
		SqlSession session = getSession();
		List<Board> boards = BoardDao.getBoardDao().searchBoardAll(session, cPage, numPerpage);
		session.close();
		
		return boards;
	}
	
	public int selectBoardCount() {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().selectBoardCount(session);
		session.close();
		
		return result;
	}
	
	public int insertBoard(Map param) {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().insertBoard(session, param);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int searchBoardCommentCount(int boardNo) {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().searchBoardCommentCount(session, boardNo);
		session.close();
		
		return result;
	}
	
	public Board searchBoardNo(Map param, boolean readFlag) {
		SqlSession session = getSession();
		Board board = BoardDao.getBoardDao().searchBoardNo(session, param);
		if(board != null && !readFlag) {
			//조회수 증가시켜주기 !
			int result = BoardDao.getBoardDao().updateReadcount(session, (int)param.get("boardNo"));
			if(result>0) {
				session.commit();
				board.setBoardReadcount(board.getBoardReadcount() + 1);
			}
			else session.rollback();
		}
		session.close();
		
		return board;
	}
	
	public int updateBoard(Map param) {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().updateBoard(session, param);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
		
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().deleteBoard(session, boardNo);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
	public int insertBoardComment(Map param) {
		SqlSession session = getSession();
		int result = BoardDao.getBoardDao().insertBoardComment(session, param);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		
		return result;
	}
	
}
