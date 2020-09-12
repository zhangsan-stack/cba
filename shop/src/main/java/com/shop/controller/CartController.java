package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@ResponseBody
	@RequestMapping("/addIntoCart")
	public String addIntoCart(Integer goods_id, Integer num, Integer price, HttpServletRequest request){
		User  user =(User) request.getSession().getAttribute("user");
		//判断是否登录，若没有，就返回登录界面
		if(user == null){
			return "redirect:/userLogin/goto_userLoginJSP";
		}

		Integer user_id = user.getId();
		System.out.println(goods_id + " " +price + "  " + user_id);

		Cart cart = new Cart();
		cart.setGoods_id(goods_id);
		cart.setUser_id(user_id);
		cart.setNum(num);
		cart.setPrice(price);
		cart.setTotal_price(num * price);
		cartService.addCart(cart);
		return "success";
	}


	//转向我的购物车页面
	@RequestMapping("/goto_myCartJSP")
	public String goto_myCartJSP(Model model, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			return  "redirect:/userLogin/goto_userLoginJSP";
		}

		Integer user_id = user.getId();
		List<Cart>  cartList=cartService.selectBy_user_id(user_id);
		model.addAttribute("cartList", cartList);
		return "myCart";

	}


}
