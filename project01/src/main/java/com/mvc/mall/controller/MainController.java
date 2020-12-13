package com.mvc.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mall.biz.ItemBiz;

@Controller
public class MainController {
	
	@Autowired
	private ItemBiz itemBiz;
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/main.do")
	public String main(Model model) {
		
		model.addAttribute("list",itemBiz.list());
		
		return "main";
	}

}
