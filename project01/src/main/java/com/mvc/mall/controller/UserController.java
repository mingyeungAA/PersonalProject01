package com.mvc.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.mall.dto.UserDto;

@Controller
public class UserController {
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String login(@RequestBody UserDto dto) {
		
		
		
		return "";
	}

}
