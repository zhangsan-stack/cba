package com.shop.service.impl;

import com.shop.entity.News;
import com.shop.mapper.NewsMapper;
import com.shop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl  implements NewsService {
	@Autowired
	NewsMapper newsMapper;
	@Override
	public List<News> selectAll() {
		return newsMapper.selectAll();
	}
}
