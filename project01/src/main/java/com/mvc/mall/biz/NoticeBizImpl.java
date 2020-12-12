package com.mvc.mall.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mall.dao.NoticeDao;
import com.mvc.mall.dto.NoticeDto;
import com.mvc.mall.dto.PagingDto;

@Service
public class NoticeBizImpl implements NoticeBiz {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<NoticeDto> list(PagingDto pagingdto) {
		return noticeDao.list(pagingdto);
	}

	@Override
	public NoticeDto detail(int notice_no) {
		return noticeDao.detail(notice_no);
	}

	@Override
	public int insert(NoticeDto dto) {
		return	noticeDao.insert(dto);
	}

	@Override
	public int update(NoticeDto dto) {
		return noticeDao.update(dto);
	}

	@Override
	public int delete(int notice_no) {
		return noticeDao.delete(notice_no);
	}

	@Override
	public int updateCountView(int notice_no) {
		return noticeDao.updateCountView(notice_no);
	}

	@Override
	public int countNotice() {
		return noticeDao.countNotice();
	}

	@Override
	public List<NoticeDto> selectSearchTitle(String search_text, PagingDto pagingdto) {
		return noticeDao.selectSearchTitle(search_text, pagingdto);
	}

	@Override
	public List<NoticeDto> selectSearchContent(String search_text, PagingDto pagingdto) {
		return noticeDao.selectSearchContent(search_text, pagingdto);
	}

	@Override
	public int countSearchTitle(String search_text) {
		return noticeDao.countSearchTitle(search_text);
	}

	@Override
	public int countSearchContent(String search_text) {
		return noticeDao.countSearchContent(search_text);
	}

}
