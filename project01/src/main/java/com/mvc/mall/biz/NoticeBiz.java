package com.mvc.mall.biz;

import java.util.List;

import com.mvc.mall.dto.NoticeDto;
import com.mvc.mall.dto.PagingDto;

public interface NoticeBiz {
	
	public List<NoticeDto> list(PagingDto pagingdto);
	public NoticeDto detail(int notice_no);
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int notice_no);
	public int updateCountView(int notice_no);
	
	public int countNotice();
	public List<NoticeDto> selectSearchTitle(String search_text, PagingDto pagingdto);
	public List<NoticeDto> selectSearchContent(String search_text, PagingDto pagingdto);
	public int countSearchTitle(String search_text);
	public int countSearchContent(String search_text);

}
