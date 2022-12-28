package com.mybatis.model.vo;

import java.sql.Date;

import lombok.Data;


@Data
public class Student {
	private int no;
	private String name;
	private String tel;
	private String email;
	private String addr;
	private Date reg_date;
//	private int studentNo;
//	private String studentName;
//	private String studentTel;
//	private String studentEmail;
//	private String studentAddr;
//	private Date reg_date;
}
