package com.shop.service;

import com.shop.entity.Item_category;

import java.util.List;

public interface Item_categoryService {

	Item_category selectById(Integer id);

	List<Item_category> selectAll();

	List<Item_category> selectBy_pid(Integer pid);
}
