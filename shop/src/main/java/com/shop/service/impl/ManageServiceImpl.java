package com.shop.service.impl;


import com.shop.entity.Manage;
import com.shop.mapper.ManageMapper;
import com.shop.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	ManageMapper manageMapper;

	@Override
	public Manage selectById(Integer id) {

		return manageMapper.selectById(id);
	}

	@Override
	public Manage selectBy_username(String username) {
		return manageMapper.selectBy_username(username);
	}
}
