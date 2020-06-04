package com.shp.web.admin.service;

/**
 * @Description: 用户社团关系表
 * @Author: sunhp
 * @Date: 2020/4/15 8:35
 */
public interface UserClubService {
    void save(Long clubId,Long userId);
    void delete(Long clubId,Long userId);
    //修改社团星级
    void updateStar(Long clubId,Integer star);
}
