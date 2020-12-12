package com.mvc.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.mall.biz.NoticeBiz;
import com.mvc.mall.dto.NoticeDto;
import com.mvc.mall.dto.PagingDto;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeBiz noticeBiz;
	private Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	//그냥 페이징
	@RequestMapping("/noticeform.do")
	public String NoticeForm(Model model, PagingDto pagingdto,
			@RequestParam(value="nowpage", required=false)String nowpage,
			@RequestParam(value="cntPerpage", required=false)String cntPerpage) {
		
		
		int total = noticeBiz.countNotice();
		if(nowpage == null && cntPerpage == null) {
			nowpage = "1";
			cntPerpage = "5";
		}else if(nowpage == null) {
			nowpage = "1";
			
		}else if(cntPerpage == null) {
			cntPerpage = "5";
		}
		
		pagingdto = new PagingDto(total, Integer.parseInt(nowpage), Integer.parseInt(cntPerpage));
		
		model.addAttribute("paging", pagingdto);
		model.addAttribute("list", noticeBiz.list(pagingdto));
		
		return "notice";
	}
	
	//search후 페이징...
	@RequestMapping("/searchnotice.do")
	public String dd(Model model, 
			PagingDto pagingdto, 
			String searchType, String search_text,
			@RequestParam(value="nowpage", required=false)String nowpage,
			@RequestParam(value="cntPerpage", required=false)String cntPerpage) {
		
		if(searchType.equals("notice_title")) {

			int total = noticeBiz.countSearchTitle(search_text);
					
			if(nowpage == null && cntPerpage == null) {
				nowpage = "1";
				cntPerpage = "5";
			}else if(nowpage == null) {
				nowpage = "1";
			}else if(cntPerpage == null) {
				cntPerpage = "5";
			}
		
			pagingdto = new PagingDto(total, Integer.parseInt(nowpage), Integer.parseInt(cntPerpage));
		
			model.addAttribute("searchType", searchType);
			model.addAttribute("search_text",search_text);
			model.addAttribute("paging", pagingdto);
			model.addAttribute("list", noticeBiz.selectSearchTitle(search_text, pagingdto));
					
			return "notice";
			
		}else if(searchType.equals("notice_content")) {

			int total = noticeBiz.countSearchContent(search_text);
			
			if(nowpage == null && cntPerpage == null) {
				nowpage = "1";
				cntPerpage = "5";
			}else if(nowpage == null) {
				nowpage = "1";
			}else if(cntPerpage == null) {
				cntPerpage = "5";
			}
			
			pagingdto = new PagingDto(total, Integer.parseInt(nowpage), Integer.parseInt(cntPerpage));
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("search_text",search_text);
			model.addAttribute("paging", pagingdto);
			model.addAttribute("list", noticeBiz.selectSearchContent(search_text, pagingdto));
			
			return "notice";
		
		}else {
			
			return "redirect:/noticeform.do";
		}
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
