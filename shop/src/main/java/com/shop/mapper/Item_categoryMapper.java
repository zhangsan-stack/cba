package com.shop.mapper;

import com.shop.entity.Item_category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Item_categoryMapper {

	Item_category selectById(@Param("id") Integer id);
	List<Item_category> selectAll();

	/*查询二级目录*/
	List<Item_category> selectBy_pid(@Param("pid") Integer pid);

}
