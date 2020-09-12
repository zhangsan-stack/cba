package com.shop.controller;

import com.shop.entity.Goods_trad_record;
import com.shop.entity.User;
import com.shop.service.Goods_trad_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Goods_trad_record")
public class Goods_trad_recordController {
	@Autowired
	Goods_trad_recordService goods_trad_recordService;


	@RequestMapping("/getMyTradRecord")
	public String getMyTradRecord(Integer buyer_id, Model model, HttpServletRequest request){
		//如果用户没有登录，则返回等了界面

		User user =(User) request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login/goto_userIndex";
		}
		//获取所有信息
		List<Goods_trad_record> goods_trad_recordList_all = goods_trad_recordService.getAll();

		//这个是状态码是0
		List<Goods_trad_record> goods_trad_recordList_0 = goods_trad_recordService.getBy_status_code(0);

		//根据交易状态码，获取不同记录,下面是状态码是1
		List<Goods_trad_record> goods_trad_recordList_1 = goods_trad_recordService.getBy_status_code(1);

		//这个是状态码是2
		List<Goods_trad_record> goods_trad_recordList_2 = goods_trad_recordService.getBy_status_code(2);
		//这个是状态码是3
		List<Goods_trad_record> goods_trad_recordList_3 = goods_trad_recordService.getBy_status_code(3);

		model.addAttribute("goods_trad_recordList_all" ,goods_trad_recordList_all);
		model.addAttribute("goods_trad_recordList_0" ,goods_trad_recordList_0);
		model.addAttribute("goods_trad_recordList_1" ,goods_trad_recordList_1);
		model.addAttribute("goods_trad_recordList_2" ,goods_trad_recordList_2);
		model.addAttribute("goods_trad_recordList_3" ,goods_trad_recordList_3);

		return "myOrder";
	}





}
