package com.shop.service;

import com.shop.entity.Shopkeeper;

import java.util.List;

public interface ShopkeeperService {
    List<Shopkeeper> selectAll();
	void insert(Shopkeeper shopkeeper);
}
