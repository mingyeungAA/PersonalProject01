package com.mvc.mall.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mall.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public UserDto login(UserDto dto) {
		UserDto result = null;
		try {
			result = sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			logger.info("[ERROR] login ");
			e.printStackTrace();
		}
		return result;
	}

}
