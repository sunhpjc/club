package com.shp.web.admin.dao;

import com.shp.domain.Activity;
import com.shp.domain.AdminUser;
import com.shp.domain.GroupApplications;
import com.shp.domain.Notice;
import com.shp.web.admin.vo.CountActivityVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description: 活动管理
 * @Author: sunhp
 * @Date: 2020/3/30 21:46
 */
@Repository
public interface ActivityDao {
    //总数====》社团一览
    List<CountActivityVo> selectCount();

    //通过id查询
    Activity getById(Long id);
    //查询所有
    List<GroupApplications> dataTableSearch(Map<String,Object> params);
    //查询总数
    int dataTableCount(Activity activity);

    //添加
    void save(Activity activity);
    //删除（批量更新状态）
    void deleteMulti(String[] idArray);
    //修改
    void update(Activity activity);

    //根据实体类查询活动，用于将新建活动添加到申请中（主要是要拿到活动id）
    Activity getByEntity(Activity activity);
}
