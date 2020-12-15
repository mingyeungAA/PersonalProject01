package com.mvc.mall.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mall.dto.QADto;

@Repository
public class QADaoImpl implements QADao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private Logger logger = LoggerFactory.getLogger(QADaoImpl.class);

	@Override
	public List<QADto> list() {
		List<QADto> result = new ArrayList<QADto>();
		try {
			result = sqlSession.selectList(NAMESPACE+"QAList");
		} catch (Exception e) {
			logger.info("[ERROR] QADaoImpl list");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(QADto dto) {
		int result = 0;
		try {
			result = sqlSession.insert(NAMESPACE+"QAInsert", dto);
		} catch (Exception e) {
			logger.info("[ERROR] QADaoImpl insert");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(QADto dto) {
		
		return 0;
	}

	@Override
	public int delete(QADto dto) {
		
		return 0;
	}

	@Override
	public QADto detail(int qa_no) {
		QADto result = null;
		result = sqlSession.selectOne(NAMESPACE+"", qa_no);
		return null;
	}

}
