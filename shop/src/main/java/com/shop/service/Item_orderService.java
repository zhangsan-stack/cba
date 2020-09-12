package com.shop.service;

import com.shop.entity.Item_order;

import java.util.List;

public interface Item_orderService {
	List<Item_order> selectAll();

	List<Item_order> selectBy_user_id(Integer user_id);
}
