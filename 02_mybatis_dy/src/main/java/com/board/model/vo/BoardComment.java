package com.board.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardComment {
	private int boardCommentNo;
	private int boardCommentLevel;
	private String boardCommentWriter;
	private String boardCommentContent;
	private int boardRef;
	private int boardCommentRef;
	private Date boardCommentDate;
}
