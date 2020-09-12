package com.shop.mapper;

import com.shop.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	User selectById(@Param("id") Integer id);
	User selectBy_username(@Param("username") String username);
}
