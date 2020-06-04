package com.shp.web.admin.dao;

import com.shp.domain.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/22 11:26
 */
@Repository
public interface PlaceDao {
    //通过状态获取地点
    List<Place> getByStatus();
}
