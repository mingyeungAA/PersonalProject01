package com.mvc.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "";
	}

}
