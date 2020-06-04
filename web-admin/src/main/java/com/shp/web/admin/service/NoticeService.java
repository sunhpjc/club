package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Notice;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/20 9:00
 */
public interface NoticeService {
    //通过id查询
    public Notice getById(Long id);
    //查询所有
    public PageInfo<Notice> dataTableSearch(int start, int length, int draw, Notice notice);

    //添加用户
    public BaseResult save(Notice notice);
    //删除(批量更新状态)
    public void deleteMulti(String[] idArray);
}
