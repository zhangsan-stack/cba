package com.shop.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
	static final long serialVersionUID =1L;
	private Integer id ;
	private String  name;
	private Integer price;
	private Integer seller_id;
	private String image;

}
