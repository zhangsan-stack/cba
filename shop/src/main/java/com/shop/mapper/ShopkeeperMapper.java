package com.shop.mapper;

import com.shop.entity.Shopkeeper;

import java.util.List;

public interface ShopkeeperMapper {
	List<Shopkeeper> selectAll();
  	void insert(Shopkeeper shopkeeper);

}
