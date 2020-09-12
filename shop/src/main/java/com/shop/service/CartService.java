package com.shop.service;

import com.shop.entity.Cart;

import java.util.List;

public interface CartService {
	List<Cart> selectAll();
	List<Cart> selectBy_user_id(Integer user_id);

    void addCart(Cart cart);

	void deleteById(Integer cartid);
}
