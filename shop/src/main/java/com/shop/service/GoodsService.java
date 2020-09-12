package com.shop.service;

import com.shop.entity.Goods;

import java.util.List;

public interface GoodsService {
	List<Goods> getAll();

	Goods getById(Integer id);

	List<Goods> fuzzyQuery(String name);
}
