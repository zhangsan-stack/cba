package com.shop.mapper;

import com.shop.entity.News;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NewsMapper {
	List<News>  selectAll();


}
