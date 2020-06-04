package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.Comments;
import com.shp.web.admin.dao.CommentsDao;
import com.shp.web.admin.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDao commentsDao;
    //通过id查询
    @Override
    public Comments getById(Long id) {
        return commentsDao.getById(id);
    }
    //后台分页
    @Override
    public PageInfo<Comments> dataTableSearch(int start, int length, int draw, Comments comments) {
        int count = commentsDao.dataTableCount(comments);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("comments",comments);

        PageInfo<Comments> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(commentsDao.dataTableSearch(params));
        return pageInfo;
    }
    //查询总数
    @Override
    public int dataTableCount(Comments comments) {
        return commentsDao.dataTableCount(comments);
    }
    //删除
    @Override
    public void deleteMulti(String[] idArray) {
        commentsDao.deleteMulti(idArray);
    }
}
