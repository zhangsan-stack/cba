package com.shop.controller;

import com.shop.entity.*;
import com.shop.service.GoodsService;
import com.shop.service.ItemService;
import com.shop.service.Item_categoryService;
import com.shop.service.ManageService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shop.entity.Goods;


import javax.servlet.http.HttpServletRequest;

import java.util.List;


@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	ManageService manageService;

	@Autowired
	ItemService itemService;

	@Autowired
	Item_categoryService item_categoryService;

	@Autowired
	GoodsService goodsService;
	@RequestMapping("/goto_adminLogin")
	public String goto_adminLogin(){

		return "adminLogin";
	}

	//使用ajax必须有返回值，这个还是尚硅谷老师的写法
	@ResponseBody
	@RequestMapping("/checkAdminLogin")
	public Msg  checkAdminLogin(String  username, String password, HttpServletRequest request){


		Manage  manage =manageService.selectBy_username(username);
		System.out.println(manage);
		if(manage != null && manage.getPassword().equals(password)){
			request.getSession().setAttribute("manage", manage);
			return Msg.Success();
		}else{
			return Msg.fail();
		}

	}


	//管理员退出,如果session失效，请重新登录，再退出
	@RequestMapping("/logout")
	public String admin_logout(HttpServletRequest request){
		Object m = (Object)request.getSession().getAttribute("manage");

		if( m!=null ){
			request.getSession().setAttribute("manage",null);
			return "redirect:/index.jsp";
		}else{
			return "adminLogin";
		}

	}

	@RequestMapping("/goto_userIndex")
	public String  goto_userIndex(Model model){
		List<Item> itemList = itemService.getAll();
		model.addAttribute("itemList", itemList);

		List<Goods> goodsList = goodsService.getAll();
		model.addAttribute("goodsList", goodsList);

		return"userIndex";
	}



	//前端页面，这里不做二级分类
	@RequestMapping("/userIndex")
	public String userIndex(Model model, HttpServletRequest request){

		return "userIndex";

	}






}
