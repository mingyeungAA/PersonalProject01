package com.mvc.mall.biz;

import java.util.List;

import com.mvc.mall.dto.QADto;

public interface QABiz {
	
	public List<QADto> list();
	public QADto detail(int qa_no);
	public int insert(QADto dto);
	public int update(QADto dto);
	public int delete(QADto dto);

}
