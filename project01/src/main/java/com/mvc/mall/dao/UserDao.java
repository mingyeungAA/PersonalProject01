package com.mvc.mall.dao;

import com.mvc.mall.dto.UserDto;

public interface UserDao {
	
	String NAMESPACE = "com.mvc.mall.user.";
	
	public UserDto login(UserDto dto);

}
