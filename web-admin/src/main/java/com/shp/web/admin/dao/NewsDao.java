package com.shp.web.admin.dao;

import com.shp.domain.News;
import com.shp.web.admin.vo.CountClubVo;
import com.shp.web.admin.vo.CountNewsVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsDao {
    //通过id查询
    public News getById(Long id);
    //查询所有
    public List<News> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(News news);
    //删除
    public void deleteMulti(String[] idArray);

    List<CountNewsVo> selectCount();

    //社团管理员功能
    //添加新闻
    void saveNews(News news);
    //查询所有
    List<News> dataTableSearch1(Map<String,Object> params);
    //查询总数
    int dataTableCount1(News news);
}
