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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.mall.biz.UserBiz;
import com.mvc.mall.dto.UserDto;
import com.mvc.util.snslogin.NaverloginVO;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private NaverloginVO naverloginVO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private void setNaverloginVO(NaverloginVO naverloginVO) {
		this.naverloginVO = naverloginVO;
	}
	
	
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
	
	/* NAVER 로그인 */
	@RequestMapping("")
	public String NaverLogin() {
		
		return "";
	}
	
	/* 로그아웃 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		logger.info(">> Logout [logout] Controller");
		session.invalidate();
		return "redirect:/";
	}
	
	/* 회원가입 */
	@RequestMapping("/signupform.do")
	public String signupForm() {
		logger.info(">> Join Us [signupForm] Controller");
		return "signup";
	}
	
	@RequestMapping("/idvalidity.do")
	@ResponseBody
	public String idValidity(@RequestParam("user_id") String user_id) {
		logger.info(">> Join Us [idValidity] Controller");
		
		int res = userBiz.idValidity(user_id);
		String res1 = Integer.toString(res);
		
		return res1;
	}
	
	@RequestMapping("/emailvalidity.do")
	@ResponseBody
	public String emailValidity(@RequestParam("user_email") String user_email) {
		logger.info(">> Join Us [emailValidity] Controller");
		
		int res = userBiz.emailValidity(user_email);
		String res1 = Integer.toString(res);
		
		return res1;
	}
	
	@RequestMapping("/signupres.do")
	public String signupRes(UserDto dto,String addr1, String addr2, String addr3) {
		logger.info(">> Join Us [signupRes] Controller");
		dto.setUser_address("("+addr1+")"+addr2+" "+addr3);
		int res = userBiz.regist(dto);
		if(res > 0) {
			return "redirect:loginform.do";
		}
		return "signup";
	}

}
