package com.shop.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Goods_trad_record implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id ;
	private Integer goods_id;
	private Integer buyer_id ;
	private Integer seller_id;
	private Integer buy_goods_number;
	private Integer goods_trad_ordercode;
	private Integer status_code;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addtime;

	private Integer realprice;
	private Integer total_money;



}
