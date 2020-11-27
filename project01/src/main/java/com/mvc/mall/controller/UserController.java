package com.mvc.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.mall.biz.UserBiz;
import com.mvc.mall.dto.UserDto;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	/* 로그인 */
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info(">> Login [loginForm] Controller");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> login(@RequestBody UserDto dto, HttpSession session) {
		logger.info(">> Login [login] Controller");
		
		UserDto userdto = userBiz.login(dto);
		logger.info("dto user_id : "+dto.getUser_id());
		boolean check = false;
		if(userdto != null) {
			session.setAttribute("login", userdto);
			check = true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	/* 회원가입 */
	@RequestMapping("/signupform.do")
	public String signupForm() {
		logger.info(">> Join Us [signupForm] Controller");
		return "signup";
	}
	
	@RequestMapping("/signupres.do")
	public String signupRes() {
		logger.info(">> Join Us [signupRes] Controller");
		
		return "";
	}

}
