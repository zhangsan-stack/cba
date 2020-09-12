package com.shop.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item_category implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id;
	private String name;
	private Integer pid;
	private Integer isdelete;


}
