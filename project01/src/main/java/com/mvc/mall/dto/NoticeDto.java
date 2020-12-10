package com.mvc.mall.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class NoticeDto {
	
	private int notice_no;
	private String notice_title;
	private String notice_writer;
	private String notice_content;
	private int notice_viewer;
	@JSONf
	private Date notice_regdate;
	
	public NoticeDto() {
		
	}

	public NoticeDto(int notice_no, String notice_title, String notice_writer, String notice_content, int notice_viewer,
			Date notice_regdate) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_writer = notice_writer;
		this.notice_content = notice_content;
		this.notice_viewer = notice_viewer;
		this.notice_regdate = notice_regdate;
	}
	
	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_viewer() {
		return notice_viewer;
	}

	public void setNotice_viewer(int notice_viewer) {
		this.notice_viewer = notice_viewer;
	}

	public Date getNotice_regdate() {
		return notice_regdate;
	}

	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
	
	

}
