package com.shop.mapper;

import com.shop.entity.Shopkeeper_account;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Shopkeeper_accountMapper {
	List<Shopkeeper_account> getAll();
	//这个方法，参数列表写错了，等下再改
	void update_moneyById(@Param("money") Integer money, @Param("id") Integer id);

	void update_moneyByName(Map hashMap);

	Shopkeeper_account getByName(@Param("name") String name);

}
