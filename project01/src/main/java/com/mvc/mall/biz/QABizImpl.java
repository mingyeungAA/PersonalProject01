package com.mvc.mall.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mall.dao.QADao;
import com.mvc.mall.dto.QADto;

@Service
public class QABizImpl implements QABiz {
	
	@Autowired
	private QADao qaDao;

	@Override
	public List<QADto> list() {
		return qaDao.list();
	}

	@Override
	public QADto detail(int qa_no) {
		return qaDao.detail(qa_no);
	}

	@Override
	public int insert(QADto dto) {
		return qaDao.insert(dto);
	}

	@Override
	public int update(QADto dto) {
		return qaDao.update(dto);
	}

	@Override
	public int delete(QADto dto) {
		return qaDao.delete(dto);
	}

}
