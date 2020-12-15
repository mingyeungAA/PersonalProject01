package com.mvc.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mall.biz.QABiz;

@Controller
public class QandAController {
	
	@Autowired
	private QABiz qaBiz;
	private Logger logger = LoggerFactory.getLogger(QandAController.class);
	
	@RequestMapping("/QandA.do")
	public String QandA(Model model) {
		model.addAttribute("list",qaBiz.list());
		
		return "qanda";
	}
	
	@RequestMapping("")
	public String QA_Insert() {
		
		return "";
	}

}
