package com.shp.web.admin.dao;

import com.shp.domain.Finance;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FinanceDao {
    //通过id查询
    Finance getById(Long id);
    //查询所有
    public List<Finance> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Finance finance);
    //删除
    public void deleteMulti(String[] idArray);

    /*
    * 社团管理员
    * */
    //查询总数
    public int dataTableCount_user(Finance finance);
    //查询所有
    public List<Finance> dataTableSearch_user(Map<String,Object> params);
    void save(Finance finance);

}
