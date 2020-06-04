package com.shp.web.ui.service;

import com.shp.domain.News;

import java.util.List;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/20 10:19
 */
public interface NewsService {
    //通过id查询
    News getById(Long id);
    //查询所有
    List<News> queryNews();
}
