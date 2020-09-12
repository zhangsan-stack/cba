package com.shop.mapper;


import com.shop.entity.MyCollection;
import org.apache.ibatis.annotations.Param;

public interface MyCollectionMapper {

	MyCollection getBy_user_id(@Param("user_id") Integer user_id);


	void addCollection(MyCollection myCollection);
}
