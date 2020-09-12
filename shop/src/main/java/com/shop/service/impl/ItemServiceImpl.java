package com.shop.service.impl;

import com.shop.entity.Item;
import com.shop.mapper.ItemMapper;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl  implements ItemService {

	@Autowired
	ItemMapper itemMapper;


	@Override
	public List<Item> getAll() {
		return itemMapper.getAll();
	}
}
