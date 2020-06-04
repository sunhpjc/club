package com.shp.web.admin.service.impl;

import com.shp.web.admin.dao.UserClubDao;
import com.shp.web.admin.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户社团关系表
 * @Author: sunhp
 * @Date: 2020/4/15 8:36
 */
@Service
public class UserClubServiceImpl implements UserClubService {
    @Autowired
    private UserClubDao userClubDao;
    @Override
    public void save(Long clubId, Long userId) {
        userClubDao.save(clubId,userId);
    }

    @Override
    public void delete(Long clubId, Long userId) {
        this.userClubDao.delete(clubId, userId);
    }

    @Override
    public void updateStar(Long clubId, Integer star) {
        userClubDao.updateStar(clubId,star);
    }

}
