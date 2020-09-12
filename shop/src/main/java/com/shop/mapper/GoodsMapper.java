package com.shop.mapper;

import com.shop.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
	List<Goods> getAll();
	Goods getById(@Param("id") Integer id);

	List<Goods> fuzzyQuery(@Param("name") String name);
}
