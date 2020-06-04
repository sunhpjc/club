package com.shp.web.ui.service.impl;

import com.shp.domain.News;
import com.shp.web.ui.dao.NewsDao;
import com.shp.web.ui.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/20 10:19
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public News getById(Long id) {
        return newsDao.getById(id);
    }

    @Override
    public List<News> queryNews() {
        return newsDao.queryNews();
    }
}
