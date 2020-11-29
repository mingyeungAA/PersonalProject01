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

	@Override
	public int idValidity(String user_id) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"id_validity", user_id);
		} catch (Exception e) {
			logger.info("[ERROR] idValidity");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int emailValidity(String user_email) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"email_validity", user_email);
		} catch (Exception e) {
			logger.info("[ERROR] emailValidity");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int regist(UserDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"signup", dto);
		} catch (Exception e) {
			logger.info("[ERROR] regist");
			e.printStackTrace();
		}
		return res;
	}

}
