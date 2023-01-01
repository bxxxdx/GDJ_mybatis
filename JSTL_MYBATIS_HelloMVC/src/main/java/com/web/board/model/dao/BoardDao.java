package com.web.board.model.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.web.board.model.vo.Board;

public class BoardDao {
	private static BoardDao boardDao;
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
	
	public int searchBoardCommentCount(SqlSession session, int boardNo) {
		return session.selectOne("board.searchBoardCommentCount", boardNo);
	}
	
	public Board searchBoardNo(SqlSession session, Map param) {
		return session.selectOne("board.searchBoardNo", param);
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
