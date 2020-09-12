package com.shop.controller;

import com.shop.entity.Item_order;
import com.shop.entity.Order_detail;
import com.shop.entity.User;
import com.shop.service.Item_orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/item_order")
@Controller
public class Item_orderController {
	@Autowired
	Item_orderService item_orderService;

	@RequestMapping("/selectAll")
	public String selectAll(Model model){
		List<Item_order>  item_orderList= item_orderService.selectAll();
		model.addAttribute("item_orderList", item_orderList);
		return "item_order";

	}
	//普通用户的订单

	@RequestMapping("/my")
	public String my(HttpServletRequest request, Model model){
		User user =(User) request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login/goto_userIndex";
		}
		Integer user_id = user.getId();


		List<Item_order>  My_item_orderList= item_orderService.selectBy_user_id(user_id);
		model.addAttribute("My_item_orderList", My_item_orderList);
		return "myOrder";

	}

}
