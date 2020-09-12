package com.shop.service;


import com.shop.entity.MyCollection;

public interface MyCollectionService {

	MyCollection getBy_user_id(Integer user_id);


	void addCollection(MyCollection myCollection);
}
