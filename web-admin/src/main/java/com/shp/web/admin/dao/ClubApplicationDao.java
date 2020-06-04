package com.shp.web.admin.dao;

import com.shp.domain.ClubApplications;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/10 16:47
 */
@Repository
public interface ClubApplicationDao {
    //通过id查询
    public ClubApplications getById(Long id);
    //查询所有
    public List<ClubApplications> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(ClubApplications clubApplications);
    //通过申请
    public void applicationPassJoin(Long id);
    //拒绝申请
    public void applicationRefuse(Long id);
}
