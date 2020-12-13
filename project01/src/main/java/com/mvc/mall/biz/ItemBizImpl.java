package com.mvc.mall.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mall.dao.ItemDao;
import com.mvc.mall.dto.ItemDto;

@Service
public class ItemBizImpl implements ItemBiz {
	
	@Autowired
	private ItemDao itemdao;

	@Override
	public List<ItemDto> list() {
		return itemdao.list();
	}

}
