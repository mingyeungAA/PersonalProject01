package com.mvc.mall.dto;

import java.util.Date;

public class QADto {
	
	private int qa_no;
	private int user_no;
	private String qa_title;
	private String qa_content;
	private String qa_regdate;
	private String user_name;
	private String user_email;
	
	public QADto() {
		
	}

	public QADto(int qa_no, int user_no, String qa_title, String qa_content, String qa_regdate, String user_name,
			String user_email) {
		super();
		this.qa_no = qa_no;
		this.user_no = user_no;
		this.qa_title = qa_title;
		this.qa_content = qa_content;
		this.qa_regdate = qa_regdate;
		this.user_name = user_name;
		this.user_email = user_email;
	}

	public int getQa_no() {
		return qa_no;
	}

	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getQa_title() {
		return qa_title;
	}

	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public String getQa_regdate() {
		return qa_regdate;
	}

	public void setQa_regdate(String qa_regdate) {
		this.qa_regdate = qa_regdate;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	

	
}
