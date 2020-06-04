package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;

import java.util.List;
import java.util.Map;

public interface AdminUserService {
    //登录
    public AdminUser login(String email,String password);
    //通过id查询
    public AdminUser getUserById(Long id);
    //查询所有
    public PageInfo<AdminUser> dataTableSearch(int start,int length,int draw,AdminUser user);
    //查询总数
    public int dataTableCount(AdminUser user);
    //查询社团，用于选择
    public List<AdminUser> searchClub();
    //添加用户
    public BaseResult save(AdminUser adminUser);
    //删除(批量更新状态)
    public void deleteMulti(String[] idArray);
    //检查用户是否存在
    //public Boolean check(AdminUser adminUser);
}
