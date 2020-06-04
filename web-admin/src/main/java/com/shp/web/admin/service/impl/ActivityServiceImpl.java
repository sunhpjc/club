package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.Activity;

import com.shp.domain.GroupApplications;

import com.shp.web.admin.dao.ActivityDao;
import com.shp.web.admin.dao.GroupApplicationDao;
import com.shp.web.admin.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/16 12:21
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private GroupApplicationDao groupApplicationDao;

    //后台分页
    @Override
    public PageInfo<GroupApplications> dataTableSearch(int start, int length, int draw, Activity activity) {
        int count = activityDao.dataTableCount(activity);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("activity",activity);

        PageInfo<GroupApplications> pageInfo = new PageInfo<>();
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

    //添加用户
    @Override
    public BaseResult save(Activity activity) {
        String beanValidator = BeanValidator.validator(activity);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            if(activity.getActivityId()==null){
                activityDao.save(activity);
                Activity activity1 = activityDao.getByEntity(activity);
                Long activityId = activity1.getActivityId();
                groupApplicationDao.insert(activityId);
            }
            else{
                activityDao.update(activity);
            }
        }
        return BaseResult.success("编辑信息成功");
    }
    //删除
    @Override
    public void deleteMulti(String[] idArray) {
        groupApplicationDao.deleteMulti(idArray);
        activityDao.deleteMulti(idArray);
    }
}
