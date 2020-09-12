package com.shop.service;

import com.shop.entity.User;

public interface UserService {
	User selectById(Integer id);
	User selectBy_username(String username);
}
