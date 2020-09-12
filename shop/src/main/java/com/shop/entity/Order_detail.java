package com.shop.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order_detail implements Serializable {
	static final long serialVersionUID =1L;
	private Integer id;

	private Integer item_id;
	private Item item;

	private Integer user_id;

	private Integer item_order_id;
	//0 未退货，1，已退货
	private Integer status;
	//数量
	private Integer	num;
	//小计
	private Integer total;

}
