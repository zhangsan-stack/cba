package com.shop.mapper;

import com.shop.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
	List<Cart> selectAll();
	List<Cart> selectBy_user_id(Integer user_id);

	void addCart(Cart cart);

	void deleteById(@Param("cartid") Integer cartid);

}
