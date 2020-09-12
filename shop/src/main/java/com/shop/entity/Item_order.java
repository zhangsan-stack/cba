package com.shop.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Item_order implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id;
	private Integer item_id;
	private Integer user_id;
	private User user;
	private Integer ordercode;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date addtime;
	private Integer total;
	private Integer isdelete;
	private Integer	status;



}
