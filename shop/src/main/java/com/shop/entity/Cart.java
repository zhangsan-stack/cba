package com.shop.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Cart implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id;
	private Integer goods_id;
	private Goods goods;
	private Integer user_id;
	private Integer num;
	private Integer price;
	private Integer total_price;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date addtime;

}
