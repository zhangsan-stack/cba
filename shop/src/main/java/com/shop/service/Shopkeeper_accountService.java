package com.shop.service;

import com.shop.entity.Shopkeeper_account;

import java.util.List;
import java.util.Map;

public interface Shopkeeper_accountService {
	List<Shopkeeper_account> getAll();

	void update_moneyById(Integer money, Integer id);

	void update_moneyByName(Map hashMap);

	Shopkeeper_account getByName(String name);
}
