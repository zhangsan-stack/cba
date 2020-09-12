package com.shop.mapper;

import com.shop.entity.Item_order;

import java.util.List;

public interface Item_orderMapper {
	List<Item_order> selectAll();


	List<Item_order> selectBy_user_id(Integer user_id);

}
