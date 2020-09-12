package com.shop.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyCollection implements Serializable {
	static final long serialVersionUID =1L;
	private Integer id;
	private Integer item_id;
	private Item item;
	private Integer user_id;





}
