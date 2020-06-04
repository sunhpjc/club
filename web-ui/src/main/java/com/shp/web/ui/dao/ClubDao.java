package com.shp.web.ui.dao;

import com.shp.domain.Club;
import com.shp.domain.ClubApplications;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/10 22:51
 */
@Repository
public interface ClubDao {
    //通过id查询
    public Club getClubById(Long id);
    //查询所有
    public List<Club> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Club club);
    //查询是否加入社团
    int join(Long userId,Long clubId);
    //加入社团，走申请流程
    void insertToClubApplication(ClubApplications clubApplications);
}
