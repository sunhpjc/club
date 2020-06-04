package com.shp.web.admin.dao;

import com.shp.domain.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/20 8:57
 */
@Repository
public interface NoticeDao {
    //通过id查询
    public Notice getById(Long id);
    //查询所有
    public List<Notice> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Notice notice);

    //添加
    public void save(Notice notice);
    //删除（批量更新状态）
    public void deleteMulti(String[] idArray);
    //修改
    public void update(Notice notice);
}
