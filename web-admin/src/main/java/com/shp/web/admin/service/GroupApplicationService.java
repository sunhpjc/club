package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.GroupApplications;

public interface GroupApplicationService {
    //通过id查询
    public GroupApplications getById(Long id);
    //查询所有
    public PageInfo<GroupApplications> dataTableSearch(int start, int length, int draw, GroupApplications groupApplications);
    //查询总数
    public int dataTableCount(GroupApplications groupApplications);
    //通过申请
    public void applicationPass(String id);
    //通过申请
    public void applicationRefuse(String id);
    //删除(批量更新状态)
    //public void deleteMulti(String[] idArray);
}
