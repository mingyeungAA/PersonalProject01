package com.mvc.mall.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mall.dto.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);

	@Override
	public List<ItemDto> list() {
		List<ItemDto> result = new ArrayList<ItemDto>();
		try {
			result = sqlSession.selectList(NAMESPACE+"Itemlist");
		} catch (Exception e) {
			logger.info("[ERROR] ItemDaoImpl list");
			e.printStackTrace();
		}
		return result;
	}

}
