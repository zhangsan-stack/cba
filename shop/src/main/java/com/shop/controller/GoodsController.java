package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	@RequestMapping("/fuzzy_query")
	public String fuzzy_query(Model model,String keywords){
		String name = keywords;
		List<Goods> goodsList_by_keywords = goodsService.fuzzyQuery(name);
		model.addAttribute( "goodsList_by_keywords",goodsList_by_keywords);
		return "keywordsResult";
	}


}
