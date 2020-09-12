package com.shop.controller;

import com.jsptags.navigation.pager.PagerTag;
import com.shop.entity.*;
import com.shop.service.CartService;
import com.shop.service.Goods_trad_recordService;
import com.shop.service.ShopkeeperService;
import com.shop.service.Shopkeeper_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/shopkeeper")
@Controller
public class ShopkeeperController {
	@Autowired
	ShopkeeperService shopkeeperService;
	@Autowired
	CartService cartService;

	@Autowired
	Shopkeeper_accountService shopkeeper_accountService;
	@Autowired
	Goods_trad_recordService goods_trad_recordService;



	//测试分页查询,使用pagehelper插件
	/*@RequestMapping("/goto_shopkeeperJSP")
	public String goto_shopkeeperJSP(Model model){
		//暂时不做商家登录界面
		List<Shopkeeper>  shopkeeperList01= shopkeeperService.selectAll();
		PageHelper.startPage(3,5);
		List<Shopkeeper>  shopkeeperList= shopkeeperService.selectAll();
		PageInfo pageInfo = new PageInfo(shopkeeperList, 2);
		System.out.println(shopkeeperList + " from ShopkeeperController");
		model.addAttribute("shopkeeperList01", shopkeeperList01);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println(pageInfo + "   from ShopkeeperController");
		return "shopkeeper";
	}


	*/
	@RequestMapping("/goto_shopkeeper")
	public String goto_shopkeeper(){

		return "shopkeeper";
	}


	//做一个显示全部的，在做一个
	@RequestMapping("/goto_shopkeeperJSP")
	public String goto_shopkeeperJSP(@RequestParam(value = "pn", required = false, defaultValue = "1")Integer pn , Model model){
		//暂时不做商家登录界面
		PageHelper.startPage(pn,5);

		List<Shopkeeper>  shopkeeperList01= shopkeeperService.selectAll();

		PageInfo pageInfos = new PageInfo(shopkeeperList01,5);

		System.out.println(pageInfos + " from ShopkeeperController");

		List<Shopkeeper>  shopkeeperList= shopkeeperService.selectAll();

		//model.addAttribute("shopkeeperList01", shopkeeperList01);

		model.addAttribute("pageInfos", pageInfos);

		return "shopkeeper";
	}

	@ResponseBody
	@RequestMapping("/I_want_buy")
	public String i_want_buy(HttpServletRequest request, Integer goodsid, Integer goodsprice, Integer cartid){
		System.out.println("cartid:  " +  cartid + " goodsid: "+ goodsid + " goodsprice:  " + goodsprice + " from ShopkeeperController");

		//本应该有一个user的银行账户，user的银行账户减少钱，商家的银行加钱，但是却没有

		//1,商家的账户加钱， 2，商品的存货量减少 3 订单状态改变 4，这是一个商家表的更新操作 5, 将购物车表的相关数据删除，根据购cartid
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			return  "redirect:/userLogin/goto_userLoginJSP";
		}

		Integer buyerid = user.getId();

		//把支付记录添加到goods_trad_record表
		Goods_trad_record goods_trad_record = new Goods_trad_record();


		goods_trad_record.setGoods_id(goodsid);
		goods_trad_record.setBuyer_id(buyerid);

		//这离暂时是一个固定值，商家的id都是1，以后要改
		goods_trad_record.setSeller_id(1);
		goods_trad_record.setBuy_goods_number(1);

		//生成一个10个数字的订单号，其实是时间戳
		long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
		Integer aa = (int)(timeNew);

		goods_trad_record.setGoods_trad_ordercode(aa);
		//改变订单状态
		goods_trad_record.setStatus_code(2);

		goods_trad_record.setAddtime(new Date());


		goods_trad_record.setRealprice(goodsprice);

		goods_trad_record.setTotal_money(goodsprice * 1);

		//把支付记录加入记录表中
		System.out.println(goods_trad_record + "  from ShopkeeperController");
		goods_trad_recordService.insert(goods_trad_record);

		//把购物车里面的相应商品清空，因为已经付款了，

		try{
			cartService.deleteById(cartid);
		}catch (Exception e){
				e.printStackTrace();
		}

		//跟新订单记录表中的订单状态，还没做

		System.out.println("删除成功");

		//根据商家姓名，获取商家对象，然后将金钱加进商家银行账户

		Shopkeeper_account shopkeeper_account = shopkeeper_accountService.getByName("商家1");
		Integer Money = shopkeeper_account.getMoney();

		Map hashMap = new HashMap();
		hashMap.put("name", "商家1 ");
		hashMap.put("money", Money+ goodsprice);

		//将商家银行账户金钱数目进行更新
		shopkeeper_accountService.update_moneyByName(hashMap);
		return "success";

	}

}
