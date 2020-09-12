package com.shop.service.impl;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User selectById(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public User selectBy_username(String username) {

		return userMapper.selectBy_username(username);
	}
}
