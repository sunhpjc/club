package com.shp.web.ui.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Activity;
import com.shp.web.ui.dao.ActivityDao;
import com.shp.web.ui.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/13 10:18
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    //后台分页
    @Override
    public PageInfo<Activity> dataTableSearch(int start, int length, int draw, Activity activity) {
        int count = activityDao.dataTableCount(activity);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("activity",activity);

        PageInfo<Activity> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(activityDao.dataTableSearch(params));
        return pageInfo;
    }

    //通过id查询用户
    @Override
    public Activity getById(Long id) {
        return activityDao.getById(id);
    }

    @Override
    public BaseResult joinActivity(Long userId, Long activityId) {
        activityDao.joinActivity(activityId,userId);
        BaseResult save = BaseResult.success("参加活动成功");
        return save;
    }

    @Override
    public int selectActivity(Long activityId, Long userId) {
        return activityDao.selectActivity(activityId,userId);
    }

    @Override
    public PageInfo<Activity> queryActivity(int start, int length, int draw, Long userId) {
        int count = activityDao.queryDataTableCount(userId);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("userId",userId);

        PageInfo<Activity> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(activityDao.queryActivity(params));
        return pageInfo;
    }
}
