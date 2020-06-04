package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.ClubApplications;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/10 16:47
 */
public interface ClubApplicationService {
    //通过id查询
    public ClubApplications getById(Long id);
    //查询所有
    public PageInfo<ClubApplications> dataTableSearch(int start, int length, int draw, ClubApplications clubApplications);
    //查询总数
    public int dataTableCount(ClubApplications clubApplications);
    //通过申请
    public void applicationPassJoin(Long id);
    //拒绝申请
    public void applicationRefuse(Long id);

}
