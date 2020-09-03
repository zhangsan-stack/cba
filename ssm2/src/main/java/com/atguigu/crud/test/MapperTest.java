package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

//测试dao层
//推荐spring的项目，使用spring单元测试，可以自动注入我们需要的组件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		/*ApplicationContext  ioc = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		ioc.getBean(DepartmentMapper.class);*/
		
		System.out.println(departmentMapper);
		
		//departmentMapper.insertSelective(new Department(null, "develop"));
		//departmentMapper.insertSelective(new Department(null, "test"));
		
		//employeeMapper.insertSelective(new Employee(null, "jerry", "m",  "jerry@qq.com", 1));
		//批量插入
		
	    EmployeeMapper mapper =  sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0; i <1000; i++) {
			String uuid =  UUID.randomUUID().toString().substring(0,5) + "" +i;
			mapper.insertSelective(new Employee(null, uuid,"m", uuid+"@qq.com",1));
			
		}
		System.out.println("批量完成");
		
	}
	
}
