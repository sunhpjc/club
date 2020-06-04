package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.AdminUser;
import com.shp.domain.Club;
import com.shp.domain.User;
import com.shp.web.admin.dao.AdminUserDao;
import com.shp.web.admin.dao.ClubDao;
import com.shp.web.admin.dao.UserDao;
import com.shp.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 社团管理员管理用户
 * @Author: sunhp
 * @Date: 2020/4/3 19:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    ClubDao clubDao;

    //通过id查询
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    //后台分页
    @Override
    public PageInfo<User> dataTableSearch(int start, int length, int draw, Club club,User user) {
        Map<String,Object> param = new HashMap<>();
        param.put("club",club);
        param.put("user",user);
        int count = userDao.dataTableCount(param);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("club",club);
        params.put("user",user);

        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userDao.dataTableSearch(params));
        return pageInfo;
    }
    //添加（新增+更新）
    @Override
    public BaseResult save(User user,Long clubId,Long userId) {
        String beanValidator = BeanValidator.validator(user);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            if(user.getUserId()==null){
                User user1 = userDao.getUserByEntity(user);
                if(user1 != null){
                    return BaseResult.fail("该账号已存在，请选择其它账号或进行修改账号信息");
                }
                userDao.save(user);
                clubDao.saveClubUser(clubId,userId);
            }
            else{
                userDao.update(user);
            }
        }
        return BaseResult.success("保存用户信息成功");
    }
    //删除(批量更新状态)
    @Override
    public void deleteMulti(String[] idArray) {
        userDao.deleteMulti(idArray);
    }

    @Override
    public User getUserByEntity(User user) {
        return userDao.getUserByEntity(user);
    }
}
