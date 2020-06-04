package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.AdminUser;
import com.shp.web.admin.dao.AdminUserDao;
import com.shp.web.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    //登录
    @Override
    public AdminUser login(String email, String password) {
        AdminUser user = adminUserDao.login(email);
        if(user!=null){
            //String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(password.equals(user.getAdminPassword())){
                return user;
            }
        }
        return null;
    }
    //通过id查询用户
    @Override
    public AdminUser getUserById(Long id) {
        return adminUserDao.getUserById(id);
    }
    //后台分页
    @Override
    public PageInfo<AdminUser> dataTableSearch(int start,int length,int draw,AdminUser user) {
        int count = adminUserDao.dataTableCount(user);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("user",user);

        PageInfo<AdminUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(adminUserDao.dataTableSearch(params));
        return pageInfo;
    }
    //查询总数
    @Override
    public int dataTableCount(AdminUser user) {
        return adminUserDao.dataTableCount(user);
    }
    //查询社团，用于选择
    @Override
    public List<AdminUser> searchClub() {
        return adminUserDao.searchClub();
    }
    //添加用户
    @Override
    public BaseResult save(AdminUser adminUser) {
        String beanValidator = BeanValidator.validator(adminUser);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            if(adminUser.getAdminId()==null){
                //adminUser.setAdminPassword(DigestUtils.md5DigestAsHex(adminUser.getAdminPassword().getBytes()));
                AdminUser adminUser1 = adminUserDao.login(adminUser.getAdminEmail());
                if(adminUser1 != null){
                    return BaseResult.fail("该账号已存在，请选择其它账号或进行修改账号信息");
                }
                adminUserDao.save(adminUser);
            }
            else{
                adminUserDao.update(adminUser);
            }
        }
        return BaseResult.success("编辑用户信息成功");
    }
    //删除(批量更新状态)
    @Override
    public void deleteMulti(String[] idArray) {
        adminUserDao.deleteMulti(idArray);
    }
    //检查用户是否存在
/*    @Override
    public Boolean check(AdminUser adminUser) {
        return null;
    }*/
}
