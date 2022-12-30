package com.board.model.service;

import static com.mybatis.common.SessionTemplate.getSessionWeb;

import org.apache.ibatis.session.SqlSession;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public Board selectBoard(int boardNo) {
		SqlSession session = getSessionWeb();
		Board b = dao.selectBoard(session, boardNo);
		session.close();
		
		return b;
	}
}
