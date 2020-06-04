package com.shp.web.ui.dao;

import com.shp.domain.AdminUser;
import com.shp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserStuDao {
    //通过邮箱登录
    public User login(String email);
    //通过id查询
    public User getUserById(Long id);
    //通过邮箱查询用户是否存在
    int getByEmail(String userEmail);
    //添加用户
    void save(User user);
    //修改用户
    void update(User user);
}
