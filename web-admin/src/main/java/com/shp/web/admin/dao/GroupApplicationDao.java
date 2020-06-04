package com.shp.web.admin.dao;

import com.shp.domain.GroupApplications;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupApplicationDao {
    //通过id查询
    public GroupApplications getById(Long id);
    //查询所有
    public List<GroupApplications> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(GroupApplications groupApplications);
    //通过申请
    public void applicationPass(String id);
    //拒绝申请
    public void applicationRefuse(String id);


    //删除(社团管理员)
    public void deleteMulti(String[] idArray);
    //社团管理员添加操作
    void insert(Long activityId);
}
