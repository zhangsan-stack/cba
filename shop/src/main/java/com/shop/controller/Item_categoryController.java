package com.shop.controller;

import com.shop.entity.Item_category;
import com.shop.service.Item_categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/item_category")
@Controller
public class Item_categoryController {

	@Autowired
	Item_categoryService item_categoryService;

	@RequestMapping("/selectAll")
	public String selectAll(Model model){
		 List<Item_category> item_categoryList=  item_categoryService.selectAll();
		 model.addAttribute("item_categoryList", item_categoryList);
		return "item_category";
	}


	//查看二级目录，前端传过来一级目录的id，就是它对应的二级补录的pid
	@RequestMapping("/selectBy_pid")
	public  String selectBy_pid(Integer pid, Model model){

		List<Item_category> item_categoryList_second = item_categoryService.selectBy_pid(pid);
		model.addAttribute("item_categoryList_second", item_categoryList_second);

		return "item_category_second";

	}


}
