package com.board.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.board.model.vo.Board;

public class BoardDao {
	
	public Board selectBoard(SqlSession session, int boardNo) {
		return session.selectOne("board.selectBoard", boardNo);
	}
}
