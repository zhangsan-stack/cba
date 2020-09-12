package com.shop.controller;


import com.shop.entity.Order_detail;
import com.shop.service.Order_detailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/order_detail")
@Controller
public class Order_detailController {
	@Autowired
	Order_detailService order_detailService;

	//显示订单
	@RequestMapping("/selectAll")
	public String selectAll(Model model){

		List<Order_detail> order_detailList = order_detailService.selectAll();
		model.addAttribute("order_detailList", order_detailList);
		return "order_detail";

	}




}
