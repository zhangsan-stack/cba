package com.shop.controller;

import com.shop.entity.Item;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/item")
@Controller
public class ItemController {
	@Autowired
	ItemService itemService;

	@RequestMapping("/getAll")
	public String getAll(Model model){
		List<Item>  itemList = itemService.getAll();
		model.addAttribute("itemList",itemList);
		return "item";
	}




}
