package com.shp.web.admin.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description: 用户社团关系表
 * @Author: sunhp
 * @Date: 2020/4/15 8:40
 */
@Repository
public interface UserClubDao {
    void save(Long clubId,Long userId);
    void delete(Long clubId,Long userId);
    //修改社团星级
    void updateStar(Long clubId,Integer star);
}
