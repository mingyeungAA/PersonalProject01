package com.mvc.mall.biz;

import com.mvc.mall.dto.UserDto;

public interface UserBiz {
	
	public UserDto login(UserDto dto);
	public int idValidity(String user_id);
	
}
