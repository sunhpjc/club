package com.shp.web.ui.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.domain.ClubApplications;
import com.shp.web.ui.dao.ClubDao;
import com.shp.web.ui.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/11 6:57
 */
@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;

    //通过id查询
    @Override
    public Club getClubById(Long id) {
        return clubDao.getClubById(id);
    }
    //后台分页
    @Override
    public PageInfo<Club> dataTableSearch(int start, int length, int draw, Club club) {
        int count = clubDao.dataTableCount(club);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("club",club);
        PageInfo<Club> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(clubDao.dataTableSearch(params));
        return pageInfo;
    }

    /**
     * 用户加入社团
     * @param userId
     * @param clubId
     * @return
     */
    @Override
    public BaseResult join(Long userId, Long clubId,String applicationDesc) {
        ClubApplications clubApplications = new ClubApplications();
        clubApplications.setUserId(userId);
        clubApplications.setClubId(clubId);
        clubApplications.setClubApplicationDesc(applicationDesc);
        clubApplications.setClubApplicationType(1);
        clubDao.insertToClubApplication(clubApplications);
        return BaseResult.success("你的申请正在处理");
    }
    @Override
    public BaseResult exit(Long userId, Long clubId,String applicationDesc) {
        ClubApplications clubApplications = new ClubApplications();
        clubApplications.setUserId(userId);
        clubApplications.setClubId(clubId);
        clubApplications.setClubApplicationDesc(applicationDesc);
        clubApplications.setClubApplicationType(0);
        clubDao.insertToClubApplication(clubApplications);
        return BaseResult.success("你的申请正在处理");
    }
}
