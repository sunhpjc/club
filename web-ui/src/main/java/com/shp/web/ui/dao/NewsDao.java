package com.shp.web.ui.dao;

import com.shp.domain.News;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/20 10:19
 */
@Repository
public interface NewsDao {
    //通过id查询
    News getById(Long id);
    //查询所有
    List<News> queryNews();
}
