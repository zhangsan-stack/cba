package com.shop.controller;

import com.shop.entity.News;
import com.shop.service.NewsService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/publicNews")
public class NewsController {

	@Autowired
	NewsService newsService;

	@RequestMapping("/selectAll")
	public String selectAll(Model model){
		List<News> newsList = newsService.selectAll();

		model.addAttribute("newsList", newsList);

		return "publicNews";



	}

}
