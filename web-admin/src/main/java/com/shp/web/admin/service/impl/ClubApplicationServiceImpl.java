package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.ClubApplications;
import com.shp.web.admin.dao.ClubApplicationDao;
import com.shp.web.admin.service.ClubApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/11 13:25
 */
@Service
public class ClubApplicationServiceImpl implements ClubApplicationService {
    @Autowired
    private ClubApplicationDao clubApplicationDao;
    //通过id查询
    @Override
    public ClubApplications getById(Long id) {
        return clubApplicationDao.getById(id);
    }
    //后台分页
    @Override
    public PageInfo<ClubApplications> dataTableSearch(int start, int length, int draw, ClubApplications clubApplications) {
        int count = clubApplicationDao.dataTableCount(clubApplications);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("clubApplications",clubApplications);

        PageInfo<ClubApplications> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(clubApplicationDao.dataTableSearch(params));
        return pageInfo;
    }
    //查询总数
    @Override
    public int dataTableCount(ClubApplications clubApplications) {
        return clubApplicationDao.dataTableCount(clubApplications);
    }
    //通过申请
    @Override
    public void applicationPassJoin(Long id) {
        clubApplicationDao.applicationPassJoin(id);
    }
    //拒绝申请
    @Override
    public void applicationRefuse(Long id) {
        clubApplicationDao.applicationRefuse(id);
    }

}
