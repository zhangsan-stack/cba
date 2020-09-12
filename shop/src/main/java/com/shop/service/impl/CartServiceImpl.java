package com.shop.service.impl;


import com.shop.entity.Cart;
import com.shop.mapper.CartMapper;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl  implements CartService {
	@Autowired
	CartMapper cartMapper;

	@Override
	public List<Cart> selectAll() {
		return cartMapper.selectAll();
	}

	@Override
	public List<Cart> selectBy_user_id(Integer user_id) {
		return cartMapper.selectBy_user_id(user_id);
	}

	@Override
	public void addCart(Cart cart) {
		cartMapper.addCart(cart);
	}

	@Override
	public void deleteById(Integer cartid) {
		cartMapper.deleteById(cartid);
	}
}
