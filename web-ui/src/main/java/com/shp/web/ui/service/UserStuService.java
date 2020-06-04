package com.shp.web.ui.service;

import com.shp.commons.dto.BaseResult;
import com.shp.domain.User;

public interface UserStuService {
    //登录
    public User login(String email, String password);
    //通过id查询
    public User getUserById(Long id);
    //保存用户
    BaseResult save(User user);
    //修改
    BaseResult update(User user);
}
