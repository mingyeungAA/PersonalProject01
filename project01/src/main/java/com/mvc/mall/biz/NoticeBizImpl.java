package com.mvc.mall.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mall.dao.NoticeDao;
import com.mvc.mall.dto.NoticeDto;

@Service
public class NoticeBizImpl implements NoticeBiz {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<NoticeDto> list() {
		return noticeDao.list();
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

}
