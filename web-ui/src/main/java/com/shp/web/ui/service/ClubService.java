package com.shp.web.ui.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/11 6:56
 */
public interface ClubService {
    //通过id查询
    public Club getClubById(Long id);
    //查询所有
    public PageInfo<Club> dataTableSearch(int start, int length, int draw, Club club);
    //查询是否用户是否已经参加社团
    BaseResult join(Long userId,Long clubId,String applicationDesc);
    BaseResult exit(Long userId,Long clubId,String applicationDesc);
    //添加（新增+更新）
    //public BaseResult save(Club club);
    //删除(批量更新状态)
    //public void deleteMulti(String[] idArray);

    //社团一览
    //PageInfo<CountClubVo> countClub(int start, int length, int draw, Club club);
    //添加用户进相应社团
    //public BaseResult save(Long clubId,Long userId);
}
