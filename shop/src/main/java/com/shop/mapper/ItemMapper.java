package com.shop.mapper;

import com.shop.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {

	List<Item> getAll();

	Item selectById(@Param("id") Integer id);
}

