package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Activity;
import com.shp.domain.GroupApplications;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/16 12:20
 */
public interface ActivityService {
    //查询所有
    PageInfo<GroupApplications> dataTableSearch(int start, int length, int draw, Activity activity);

    //通过id查询
    Activity getById(Long id);

    //添加用户
    public BaseResult save(Activity activity);
    //删除(批量更新状态)
    public void deleteMulti(String[] idArray);
}
