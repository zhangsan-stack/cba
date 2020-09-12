package com.shop.service.impl;

import com.shop.entity.Item_category;
import com.shop.mapper.Item_categoryMapper;
import com.shop.service.Item_categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Item_categoryServiceImpl implements Item_categoryService {

	@Autowired
	Item_categoryMapper item_categoryMapper;


	@Override
	public Item_category selectById(Integer id) {
		return item_categoryMapper.selectById(id);
	}


	@Override
	public List<Item_category> selectAll() {
		return item_categoryMapper.selectAll();
	}



	@Override
	public List<Item_category> selectBy_pid(Integer pid) {
		return item_categoryMapper.selectBy_pid(pid);
	}
}
