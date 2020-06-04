package com.shp.web.ui.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Activity;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/13 10:18
 */
public interface ActivityService {
    //查询所有
    PageInfo<Activity> dataTableSearch(int start, int length, int draw, Activity activity);

    //通过id查询
    Activity getById(Long id);

    //添加社团
    BaseResult joinActivity(Long userId,Long activityId);
    //查询是否已经参加活动
    int selectActivity(Long activityId,Long userId);
    //查询已参加的活动
    PageInfo<Activity> queryActivity(int start, int length, int draw, Long userId);

}
