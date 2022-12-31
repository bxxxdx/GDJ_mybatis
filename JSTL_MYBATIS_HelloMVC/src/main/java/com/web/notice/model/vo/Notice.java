package com.web.notice.model.vo;

import java.sql.Date;

import com.web.member.model.vo.Member;

import lombok.Builder;
import lombok.Data;

@Data
public class Notice { 
	private int noticeNo;
	private String noticeTitle;
//	private String noticeWriter; 
	private Member member;
	private String noticeContent;
	private Date noticeDate;
	private String filePath;
	private char status;
}
