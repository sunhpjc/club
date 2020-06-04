package com.shp.web.admin.service;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.web.admin.vo.CountClubVo;

import java.util.List;

public interface ClubService {
    //通过id查询
    public Club getClubById(Long id);
    //查询所有
    public PageInfo<Club> dataTableSearch(int start, int length, int draw, Club club);
    //查询总数
    public int dataTableCount(Club club);
    //添加（新增+更新）
    public BaseResult save(Club club);
    //删除(批量更新状态)
    public void deleteMulti(String[] idArray);

    //社团一览
    PageInfo<CountClubVo> countClub(int start, int length, int draw, Club club);
    //添加用户进相应社团
    public BaseResult save(Long clubId,Long userId);
}
