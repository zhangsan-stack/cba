package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model) {
		//有一千条数据
		//引入PageHlper插件
		//在查询之前，调用方法，传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		//后面就是分页查询
		
		
		List<Employee> emps = employeeService.getAll();
		//使用pageinfo包装查询后的结果，只需要将pageinfo交给页面，里面已经封装了详细的信息
		//第二个参数5，是连续显示几页
		PageInfo pageInfo = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", pageInfo);
		
		return "list";
	}
	
	
}
