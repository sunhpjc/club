package com.shp.web.admin.dao;

import com.shp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description: 社团管理员管理用户
 * @Author: sunhp
 * @Date: 2020/4/3 19:31
 */
@Repository
public interface UserDao {
    //通过id查询
    public User getUserById(Long id);
    //查询所有
    public List<User> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Map<String,Object> params);
    //添加
    public void save(User user);
    //删除（批量更新状态）
    public void deleteMulti(String[] idArray);
    //修改
    public void update(User user);

    User getUserByEntity(User user);
}
