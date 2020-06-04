package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.Notice;
import com.shp.web.admin.dao.NoticeDao;
import com.shp.web.admin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/20 9:02
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    //通过id查询用
    @Override
    public Notice getById(Long id) {
        return noticeDao.getById(id);
    }
    //后台分页
    @Override
    public PageInfo<Notice> dataTableSearch(int start, int length, int draw, Notice notice) {
        int count = noticeDao.dataTableCount(notice);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("notice",notice);

        PageInfo<Notice> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(noticeDao.dataTableSearch(params));
        return pageInfo;
    }

    //添加用户
    @Override
    public BaseResult save(Notice notice) {
        String beanValidator = BeanValidator.validator(notice);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            if(notice.getNoticesId()==null){
                noticeDao.save(notice);
            }
            else{
                noticeDao.update(notice);
            }
        }
        return BaseResult.success("编辑信息成功");
    }
    //删除(批量更新状态)
    @Override
    public void deleteMulti(String[] idArray) {
        noticeDao.deleteMulti(idArray);
    }
}
