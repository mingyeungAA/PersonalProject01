package com.mvc.mall.dto;

import java.util.Date;

public class ItemDto {
	private int item_no;
	private int group_no;
	private int category_no;
	private String item_name;
	private String item_color;
	private String item_size;
	private String item_price;
	private int item_sku;
	private String item_photo;
	private String item_content;
	private Date createdat;
	
	public ItemDto() {
		
	}

	public ItemDto(int item_no, int group_no, int category_no, String item_name, String item_color, String item_size,
			String item_price, int item_sku, String item_photo, String item_content, Date createdat) {
		super();
		this.item_no = item_no;
		this.group_no = group_no;
		this.category_no = category_no;
		this.item_name = item_name;
		this.item_color = item_color;
		this.item_size = item_size;
		this.item_price = item_price;
		this.item_sku = item_sku;
		this.item_photo = item_photo;
		this.item_content = item_content;
		this.createdat = createdat;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public int getGroup_no() {
		return group_no;
	}

	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_color() {
		return item_color;
	}

	public void setItem_color(String item_color) {
		this.item_color = item_color;
	}

	public String getItem_size() {
		return item_size;
	}

	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public int getItem_sku() {
		return item_sku;
	}

	public void setItem_sku(int item_sku) {
		this.item_sku = item_sku;
	}

	public String getItem_photo() {
		return item_photo;
	}

	public void setItem_photo(String item_photo) {
		this.item_photo = item_photo;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
	

}
