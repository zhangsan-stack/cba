package com.shop.controller;

import com.shop.entity.MyCollection;
import com.shop.entity.User;
import com.shop.service.MyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/myCollection")
public class MyCollectionController {
	@Autowired
	MyCollectionService myCollectionService;

	@RequestMapping("/addCollection")
	public String addCollection(Integer item_id,Integer user_id, HttpServletRequest request){
		//如果用户没有登录，则返回等了界面

		User user =(User) request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login/goto_userIndex";
		}


		MyCollection myCollection  = new MyCollection();
		myCollection.setItem_id(item_id);
		myCollection.setUser_id(user_id);

		myCollectionService.addCollection(myCollection);

		return "redirect:/index.jsp";

	}

}
