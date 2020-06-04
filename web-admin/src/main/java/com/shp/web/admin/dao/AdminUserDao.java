package com.shp.web.admin.dao;

import com.shp.domain.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminUserDao {
    //通过邮箱登录
    public AdminUser login(String email);
    //通过id查询
    public AdminUser getUserById(Long id);
    //查询所有
    public List<AdminUser> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(AdminUser user);
    //查询社团，用于选择
    public List<AdminUser> searchClub();
    //添加用户
    public void save(AdminUser adminUser);
    //删除（批量更新状态）
    public void deleteMulti(String[] idArray);
    //修改
    public void update(AdminUser adminUser);
}
