package com.shop.controller;

import com.shop.entity.Goods_trad_record;
import com.shop.entity.User;
import com.shop.service.Goods_trad_recordService;
import com.shop.service.UserService;
import com.shop.util.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RequestMapping("/userLogin")
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	Goods_trad_recordService goods_trad_recordService;

	//只是一个转发功能
	@RequestMapping("/goto_userLoginJSP")
	public String goto_userLoginJSP(){

		return "userLogin";
	}


	@RequestMapping("/check_userLogin")
	public String check_userLogin(String username, String password, String checkCode, HttpServletRequest request){

		User user = userService.selectBy_username(username);

		//查看前后端，验证码是否一致,并且进行类型转换
		String checkCode_from_session =(String) request.getSession().getAttribute("check_code_String");
		if(user == null){
			return "redirect:/login/goto_userIndex";
		}

		if(checkCode == ""){

			return "redirect:/login/goto_userIndex";
		}
		if(checkCode == null){

			return "redirect:/login/goto_userIndex";
		}
		if(user.getUsername() ==""){
			return "redirect:/login/goto_userIndex";

		}
		if(user.getPassword() ==""){
			return "redirect:/login/goto_userIndex";
		}


		if(user != null && user.getPassword().equals(password) && (checkCode_from_session.equals(checkCode)) ){
			request.getSession().setAttribute("user", user);
			System.out.println("success");
			return "redirect:/login/goto_userIndex";
		}else{
			return "userIndex";
		}
	}


	@RequestMapping("/myCenter")
	public String goto_myCenterJSP(Integer buyer_id ,HttpServletRequest request, Model model){
		User user =(User) request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/login/goto_userIndex";
		}
		List<Goods_trad_record> goods_trad_recordList =  goods_trad_recordService.getBy_buyer_id(buyer_id);
		model.addAttribute("goods_trad_recordList" ,goods_trad_recordList);

		return "myCenter";
	}

	//页面要的验证码
	@RequestMapping("/getCheckCode")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response){
		CheckCode checkCode = new CheckCode();
		//生成一个验证码，存入seesion中,一定要把验证码数字存入session中
		String check_code_String  = checkCode.generateCheckCode();
		System.out.println(check_code_String + " :: check_code_String");
		request.getSession().setAttribute("check_code_String", check_code_String);

		//创建一bai张图片
		BufferedImage image = new BufferedImage(200,50,BufferedImage.TYPE_INT_RGB);
		//得到图片
		Graphics2D g = (Graphics2D)image.getGraphics();
		g.fillRect(0, 0, 200, 70);
		//向图片上写写数据
		g.setColor(Color.blue);//设置图片颜色
		g.setFont(new Font("隶书",Font.ITALIC,50));
		//把想要写的字符串画在图片上,参数x和y是字符串左上角的坐标，记住了，y值越大，字符串越往下
		g.drawString(check_code_String, 10, 40);//画图片
		//在session中放置该图片
		//request.getSession().setAttribute("check_code_String", check_code_String);//把图片存在session中
		//将图片返回给前端
		try {
			ImageIO.write(image,"jpg", response.getOutputStream());//输出图片
		} catch (IOException e) {
			e.printStackTrace();
		}
	}






}
