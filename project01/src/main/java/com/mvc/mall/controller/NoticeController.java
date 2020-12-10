package com.mvc.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mall.biz.NoticeBiz;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeBiz noticeBiz;

	@RequestMapping("/noticeform.do")
	public String NoticeForm(Model model) {
		
		model.addAttribute("list",noticeBiz.list());
		
		return "notice";
	}
}
