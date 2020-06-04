package com.shp.web.admin.dao;

import com.shp.domain.Comments;
import com.shp.domain.GroupApplications;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentsDao {
    //通过id查询
    public Comments getById(Long id);
    //查询所有
    public List<Comments> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Comments comments);
    //删除
    public void deleteMulti(String[] idArray);
    //根据newsId删除
    public void deleteByNewsId(String[] idArray);
}
