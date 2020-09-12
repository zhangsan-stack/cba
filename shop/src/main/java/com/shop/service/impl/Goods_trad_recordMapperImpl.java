package com.shop.service.impl;

import com.shop.entity.Goods_trad_record;
import com.shop.mapper.Goods_trad_recordMapper;
import com.shop.service.Goods_trad_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_trad_recordMapperImpl  implements Goods_trad_recordService {
	@Autowired
	Goods_trad_recordMapper goods_trad_recordMapper;

	@Override
	public List<Goods_trad_record> getAll() {
		return goods_trad_recordMapper.getAll();
	}

	@Override
	public List<Goods_trad_record> getBy_buyer_id(Integer buyer_id) {
		return goods_trad_recordMapper.getBy_buyer_id(buyer_id);
	}

	@Override
	public void insert(Goods_trad_record goods_trad_record) {
		System.out.println(goods_trad_record + "  from Service");
		goods_trad_recordMapper.insert(goods_trad_record);
	}

	@Override
	public List<Goods_trad_record> getBy_status_code(Integer status_code) {
		return goods_trad_recordMapper.getBy_status_code(status_code);
	}
}
