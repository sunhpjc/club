package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.Club;
import com.shp.domain.Finance;
import com.shp.web.admin.dao.FinanceDao;
import com.shp.web.admin.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceDao financeDao;

    @Override
    public Finance getById(Long id) {
        return financeDao.getById(id);
    }

    //后台分页
    @Override
    public PageInfo<Finance> dataTableSearch(int start, int length, int draw, Finance finance) {
        int count = financeDao.dataTableCount(finance);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("finance",finance);

        PageInfo<Finance> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(financeDao.dataTableSearch(params));
        return pageInfo;
    }
    //删除
    @Override
    public void deleteMulti(String[] idArray) {
        financeDao.deleteMulti(idArray);
    }


    /*
    * 社团管理员
    * */
    @Override
    public PageInfo<Finance> dataTableSearch_user(int start, int length, int draw, Finance finance) {
        int count = financeDao.dataTableCount_user(finance);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("finance",finance);

        PageInfo<Finance> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(financeDao.dataTableSearch_user(params));
        return pageInfo;
    }

    @Override
    public BaseResult save(Finance finance) {
        String beanValidator = BeanValidator.validator(finance);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            financeDao.save(finance);
        }
        return BaseResult.success("保存用户信息成功");
    }

}
