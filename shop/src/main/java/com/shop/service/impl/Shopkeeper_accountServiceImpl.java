package com.shop.service.impl;

import com.shop.entity.Shopkeeper_account;
import com.shop.mapper.Shopkeeper_accountMapper;
import com.shop.service.Shopkeeper_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Shopkeeper_accountServiceImpl  implements Shopkeeper_accountService {
	@Autowired
	Shopkeeper_accountMapper shopkeeper_accountMapper;

	@Override
	public List<Shopkeeper_account> getAll() {

		return shopkeeper_accountMapper.getAll();
	}

	@Override
	public void update_moneyById(Integer money, Integer id) {
		shopkeeper_accountMapper.update_moneyById(money, id);
	}

	@Override
	public void update_moneyByName(Map hashMap) {
		shopkeeper_accountMapper.update_moneyByName(hashMap);
	}

	@Override
	public Shopkeeper_account getByName(String name) {
		return shopkeeper_accountMapper.getByName(name);
	}


}
