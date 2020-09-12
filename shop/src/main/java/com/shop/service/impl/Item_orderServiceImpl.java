package com.shop.service.impl;

import com.shop.entity.Item;
import com.shop.entity.Item_order;
import com.shop.mapper.Item_orderMapper;
import com.shop.service.Item_orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Item_orderServiceImpl implements Item_orderService {
	@Autowired
	Item_orderMapper item_orderMapper;

	@Override
	public List<Item_order> selectAll() {
		return  item_orderMapper.selectAll();
	}

	@Override
	public List<Item_order> selectBy_user_id(Integer user_id) {
		return item_orderMapper.selectBy_user_id(user_id);
	}
}
