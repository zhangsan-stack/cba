package com.shop.mapper;

import com.shop.entity.Goods_trad_record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Goods_trad_recordMapper {
	List<Goods_trad_record> getAll();


	List<Goods_trad_record> getBy_buyer_id(@Param("buyer_id") Integer buyer_id);

	void insert(Goods_trad_record goods_trad_record);


	List<Goods_trad_record> getBy_status_code(@Param("status_code") Integer status_code );
}
