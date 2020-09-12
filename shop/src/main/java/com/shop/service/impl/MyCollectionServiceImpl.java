package com.shop.service.impl;


import com.shop.entity.MyCollection;
import com.shop.mapper.MyCollectionMapper;
import com.shop.service.MyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCollectionServiceImpl implements MyCollectionService {

	@Autowired
	MyCollectionMapper myCollectionMapper;

	public MyCollection getBy_user_id(Integer user_id){
		return  myCollectionMapper.getBy_user_id(user_id);
	}

	@Override
	public void addCollection(MyCollection myCollection) {

		myCollectionMapper.addCollection(myCollection);
	}
}
