package com.shop.mapper;

import com.shop.entity.Manage;
import org.apache.ibatis.annotations.Param;

public interface ManageMapper {
	//@Param这注解不用的话，大多数情况是不会报错的，但是有例外，2020年9月4日08:09:34
	Manage selectById (@Param("id") Integer id);

	Manage selectBy_username(@Param("username") String username);
}
