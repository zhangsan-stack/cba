package com.shop.service.impl;

import com.shop.entity.Shopkeeper;
import com.shop.mapper.ShopkeeperMapper;
import com.shop.service.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopkeeperServiceImpl implements ShopkeeperService {
	@Autowired
	ShopkeeperMapper shopkeeperMapper;

	@Override
	public List<Shopkeeper> selectAll() {

		return shopkeeperMapper.selectAll();
	}

	@Override
	public void insert(Shopkeeper shopkeeper) {
		shopkeeperMapper.insert(shopkeeper);
	}


}
