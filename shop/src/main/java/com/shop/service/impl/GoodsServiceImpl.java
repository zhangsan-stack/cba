package com.shop.service.impl;

import com.shop.entity.Goods;
import com.shop.mapper.GoodsMapper;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl  implements GoodsService {
	@Autowired
	GoodsMapper goodsMapper;

	@Override
	public List<Goods> getAll() {
		return goodsMapper.getAll();
	}

	@Override
	public Goods getById(Integer id) {
		return goodsMapper.getById(id);
	}

	@Override
	public List<Goods> fuzzyQuery(String name) {
		return goodsMapper.fuzzyQuery(name);
	}
}
