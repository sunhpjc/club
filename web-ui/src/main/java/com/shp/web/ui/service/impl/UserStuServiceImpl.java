package com.shp.web.ui.service.impl;

import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.User;

import com.shp.web.ui.dao.UserStuDao;
import com.shp.web.ui.service.UserStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStuServiceImpl implements UserStuService {
    @Autowired
    private UserStuDao userStuDao;
    //登录
    @Override
    public User login(String email, String password) {
        User user = userStuDao.login(email);
        if(user!=null){
            //String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(password.equals(user.getUserPassword())){
                return user;
            }
        }
        return null;
    }
    //通过id查询用户
    @Override
    public User getUserById(Long id) {
        return userStuDao.getUserById(id);
    }

    //保存用户
    @Override
    public BaseResult save(User user) {
        String beanValidator = BeanValidator.validator(user);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            int num = userStuDao.getByEmail(user.getUserEmail());
            if(num>0){
                return BaseResult.fail("邮箱已经被注册");
            }
            else{
                userStuDao.save(user);
            }
        }
        return BaseResult.success("注册用户信息成功");
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public BaseResult update(User user) {
        userStuDao.update(user);
        return BaseResult.success("修改用户信息成功");
    }
}
