package com.shop.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

//新遇到的类，这个牛啊，专门为页面服务的


@Data
public class CategoryDto implements Serializable {
	static final long serialVersionUID =1L;
	private Item_category father;
	private List<Item_category> children;
}
