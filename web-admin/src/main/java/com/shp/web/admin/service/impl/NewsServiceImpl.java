package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.News;
import com.shp.web.admin.dao.CommentsDao;
import com.shp.web.admin.dao.NewsDao;
import com.shp.web.admin.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private CommentsDao commentsDao;
    //通过id查询
    @Override
    public News getById(Long id) {
        return newsDao.getById(id);
    }
    //后台分页
    @Override
    public PageInfo<News> dataTableSearch(int start, int length, int draw, News news) {
        int count = newsDao.dataTableCount(news);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("news",news);

        PageInfo<News> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(newsDao.dataTableSearch(params));
        return pageInfo;
    }
    //查询总数
    @Override
    public int dataTableCount(News news) {
        return newsDao.dataTableCount(news);
    }
    //删除
    @Override
    public void deleteMulti(String[] idArray) {
        commentsDao.deleteByNewsId(idArray);
        newsDao.deleteMulti(idArray);
    }

    //以下为社团管理员功能
    //添加新闻
    @Override
    public BaseResult saveNews(News news) {
        newsDao.saveNews(news);
        return BaseResult.success("发布新闻成功");
    }
    //后台分页
    @Override
    public PageInfo<News> dataTableSearch1(int start, int length, int draw, News news) {
        int count = newsDao.dataTableCount1(news);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("news",news);

        PageInfo<News> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(newsDao.dataTableSearch1(params));
        return pageInfo;
    }
}
