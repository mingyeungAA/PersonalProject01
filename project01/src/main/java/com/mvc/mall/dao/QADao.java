package com.mvc.mall.dao;

import java.util.List;

import com.mvc.mall.dto.QADto;

public interface QADao {
	
	String NAMESPACE = "com.mvc.mall.qanda.";
	
	public List<QADto> list();
	public QADto detail(int qa_no);
	public int insert(QADto dto);
	public int update(QADto dto);
	public int delete(QADto dto);
	

}
