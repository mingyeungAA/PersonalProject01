package com.mvc.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	private Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@RequestMapping("/mypage.do")
	public String Mypage() {
		return "mypage";
	}

}
