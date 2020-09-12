package com.shop.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable {
	static final long serialVersionUID =1L;

	private Integer id;
	private String  name;
	private String  content;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date addtime;
}
