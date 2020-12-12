package com.mvc.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mall.biz.NoticeBiz;
import com.mvc.mall.dto.NoticeDto;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeBiz noticeBiz;

	@RequestMapping("/noticeform.do")
	public String NoticeForm(Model model) {
		
		model.addAttribute("list",noticeBiz.list());
		
		return "notice";
	}
	
	@RequestMapping("/noticedetail.do")
	public String NoticeDetail(Model model, int notice_no) {
		int res = noticeBiz.updateCountView(notice_no);
		if(res > 0) {
			
			model.addAttribute("dto",noticeBiz.detail(notice_no));
			return "notice_detail";
		}
		
		return "notice_detail";
	}
	
	@RequestMapping("/noticeinsert.do")
	public String NoticeInsert() {
		
		return "notice_insert";
	}
	
	@RequestMapping("/noticeinsertRes.do")
	public String NoticeInsertRes(NoticeDto dto) {
		int res = noticeBiz.insert(dto);
		if(res > 0) {
			return "redirect:noticeform.do";
		}
		return "notice_insert";
	}
	
	@RequestMapping("/noticeupdate.do")
	public String NoticeUpdate(Model model, int notice_no) {
		model.addAttribute("dto", noticeBiz.detail(notice_no));
		return "notice_update";
	}
	
	@RequestMapping("/noticeupdateRes.do")
	public String NoticeUpdateRes(NoticeDto dto, Model model, int notice_no) {
		int res = noticeBiz.update(dto);
		if(res > 0) {
			return "redirect:noticedetail.do?notice_no="+notice_no;
		}
		return "redirect:noticedetail.do?notice_no="+notice_no;
	}
	
	@RequestMapping("/noticedelete.do")
	public String NoticeDelete(int notice_no) {
		int res = noticeBiz.delete(notice_no);
		if(res > 0) {
			return "redirect:noticeform.do";
		}
		return "redirect:noticeform.do";
	}
}
