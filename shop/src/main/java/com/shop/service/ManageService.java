package com.shop.service;

import com.shop.entity.Manage;

public interface ManageService {
	Manage  selectById(Integer id);

	Manage selectBy_username(String username);
}
