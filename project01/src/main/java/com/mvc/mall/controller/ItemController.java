package com.mvc.mall.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mall.dto.ItemDto;

@Controller
public class ItemController {
	
	@RequestMapping("/itemList.do")
	public List<ItemDto> ItemList(){
		
		
		return null;
	}

}
