package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.GroupApplications;
import com.shp.web.admin.dao.GroupApplicationDao;
import com.shp.web.admin.service.GroupApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GroupApplicationServiceImpl implements GroupApplicationService {
    @Autowired
    private GroupApplicationDao groupApplicationDao;
    //通过id查询
    @Override
    public GroupApplications getById(Long id) {
        return groupApplicationDao.getById(id);
    }
    //后台分页
    @Override
    public PageInfo<GroupApplications> dataTableSearch(int start, int length, int draw, GroupApplications groupApplications) {
        int count = groupApplicationDao.dataTableCount(groupApplications);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("groupApplications",groupApplications);

        PageInfo<GroupApplications> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(groupApplicationDao.dataTableSearch(params));
        return pageInfo;
    }
    //查询总数
    @Override
    public int dataTableCount(GroupApplications groupApplications) {
        return groupApplicationDao.dataTableCount(groupApplications);
    }
    //通过申请
    @Override
    public void applicationPass(String id) {
        groupApplicationDao.applicationPass(id);
    }
    //拒绝申请
    @Override
    public void applicationRefuse(String id) {
        groupApplicationDao.applicationRefuse(id);
    }
    //删除(批量更新状态)
    /*@Override
    public void deleteMulti(String[] idArray) {
        clubDao.deleteMulti(idArray);
    }*/
}
