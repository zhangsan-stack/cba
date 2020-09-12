package com.shop.service;



import com.shop.entity.Goods_trad_record;

import java.util.List;

public interface Goods_trad_recordService {
	List<Goods_trad_record> getAll();
	List<Goods_trad_record> getBy_buyer_id(Integer buyer_id);

	void insert(Goods_trad_record goods_trad_record);

	List<Goods_trad_record> getBy_status_code(Integer status_code);
}
