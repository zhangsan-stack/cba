package com.shop.service.impl;

import com.shop.entity.Order_detail;
import com.shop.service.Order_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_detailServiceImpl implements Order_detailService {

	@Autowired
	Order_detailService order_detailService;
	@Override
	public List<Order_detail> selectAll() {

		return order_detailService.selectAll();
	}
}
