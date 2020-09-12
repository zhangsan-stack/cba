package com.shop.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id;
	private String  name;
	private Integer price;
	private Integer  discount ;
	private Integer collectionnum ;
	private Integer buynum;
	private String  url1 ;
	private String  url2 ;
	private String  url3 ;
	private String  url4 ;
	private String  url5 ;
	private String  detail;
	private String  param1 ;
	private String  param2 ;
	private String  param3 ;
	private String  var1 ;
	private String  var2 ;
	private String  var3 ;
	private Integer type;

	private Integer  category_id_one;
	private Item_category first;

	private Integer category_id_two;
	private Item_category second;

	private Integer	isdelete;




}
