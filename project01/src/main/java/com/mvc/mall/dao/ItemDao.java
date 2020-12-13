package com.mvc.mall.dao;

import java.util.List;

import com.mvc.mall.dto.ItemDto;

public interface ItemDao {

	String NAMESPACE = "com.mvc.mall.item.";
	
	public List<ItemDto> list();
	
}
