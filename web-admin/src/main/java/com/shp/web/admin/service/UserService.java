package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.domain.User;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/3 19:33
 */
public interface UserService {
    //通过id查询
    public User getUserById(Long id);

    //查询所有
    public PageInfo<User> dataTableSearch(int start, int length, int draw, Club club, User user);

    //添加（新增+更新）
    public BaseResult save(User user,Long clubId,Long userId);

    //删除(批量更新状态)
    public void deleteMulti(String[] idArray);

    //通过实体查询（邮箱，电话，学号}
    User getUserByEntity(User user);
}
