package com.shp.web.ui.dao;

import com.shp.domain.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/13 10:17
 */
@Repository
public interface ActivityDao {

    //通过id查询
    Activity getById(Long id);
    //查询所有
    List<Activity> dataTableSearch(Map<String,Object> params);
    //查询总数
    int dataTableCount(Activity activity);

    //参加活动
    void joinActivity(Long activityId,Long userId);
    //查询是否已经参加活动
    int selectActivity(Long activityId,Long userId);
    //查询已参加的活动
    List<Activity> queryActivity(Map<String,Object> params);
    //已参加活动数
    int queryDataTableCount(Long userId);
}
