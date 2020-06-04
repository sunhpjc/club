package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.News;

public interface NewsService {
    //通过id查询
    public News getById(Long id);
    //查询所有
    public PageInfo<News> dataTableSearch(int start, int length, int draw, News news);
    //查询总数
    public int dataTableCount(News news);
    //删除
    public void deleteMulti(String[] idArray);

    //以下为社团管理员功能
    //添加新闻
    BaseResult saveNews(News news);

    PageInfo<News> dataTableSearch1(int start, int length, int draw, News news);
}
