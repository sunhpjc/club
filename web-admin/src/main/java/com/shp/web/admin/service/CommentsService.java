package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.Comments;

public interface CommentsService {
    //通过id查询
    public Comments getById(Long id);
    //查询所有
    public PageInfo<Comments> dataTableSearch(int start, int length, int draw, Comments comments);
    //查询总数
    public int dataTableCount(Comments comments);
    //删除
    public void deleteMulti(String[] idArray);
}
