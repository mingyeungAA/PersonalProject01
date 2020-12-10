package com.mvc.mall.biz;

import java.util.List;

import com.mvc.mall.dto.NoticeDto;

public interface NoticeBiz {
	
	public List<NoticeDto> list();
	public NoticeDto detail(int notice_no);
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int notice_no);
	public int updateCountView(int notice_no);

}
