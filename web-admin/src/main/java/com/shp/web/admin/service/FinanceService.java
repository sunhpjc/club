package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.domain.Finance;

public interface FinanceService {
    //通过id查询
    Finance getById(Long id);
    //查询所有
    public PageInfo<Finance> dataTableSearch(int start, int length, int draw, Finance finance);
    //删除
    public void deleteMulti(String[] idArray);

    /*
    * 社团管理员
    * */
    //查询所有
    public PageInfo<Finance> dataTableSearch_user(int start, int length, int draw, Finance finance);
    //保存用户信息
    BaseResult save(Finance finance);
}
