package com.web.board.model.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.web.board.model.vo.Board;
import com.web.board.model.vo.BoardComment;

public class BoardDao {
	private static BoardDao boardDao;
	private Properties sql = new Properties();
	private BoardDao() {}
	public static BoardDao getBoardDao() {
		if(boardDao == null) boardDao = new BoardDao();
		return boardDao;
	}
	
	public List<Board> searchBoardAll(SqlSession session, int cPage, int numPerpage){
		RowBounds rb = new RowBounds((cPage-1)*numPerpage, numPerpage);
		return session.selectList("board.searchBoardAll", null, rb);
	}
	
	public int selectBoardCount(SqlSession session) {
		return session.selectOne("board.selectBoardCount");
	}
	
	public int insertBoard(SqlSession session, Map param) {
		return session.insert("board.insertBoard", param);
	}
	
	public Board searchBoardNo(SqlSession session, int boardNo) {
		return session.selectOne("board.searchBoardNo", boardNo);
	}
	
	public int updateReadcount(SqlSession session, int boardNo) {
		return session.update("board.updateReadcount", boardNo);
	}
	
	public int updateBoard(SqlSession session, Map param) {
		return session.update("board.updateBoard", param);
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("board.deleteBoard", boardNo);
	}
	
	public int insertBoardComment(SqlSession session, Map param) {
		return session.insert("insertBoardComment", param);
	}
	
}
