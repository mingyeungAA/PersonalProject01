package com.mvc.mall.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mall.dao.UserDao;
import com.mvc.mall.dto.UserDto;
@Service
public class UserBizImpl implements UserBiz {
	
	@Autowired
	private UserDao userdao;

	@Override
	public UserDto login(UserDto dto) {
		return userdao.login(dto);
	}

	@Override
	public int idValidity(String user_id) {
		return userdao.idValidity(user_id);
	}

}
