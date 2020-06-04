package com.shp.web.admin.service.impl;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.commons.validator.BeanValidator;
import com.shp.domain.Club;
import com.shp.web.admin.dao.ActivityDao;
import com.shp.web.admin.dao.ClubDao;
import com.shp.web.admin.dao.NewsDao;
import com.shp.web.admin.service.ClubService;
import com.shp.web.admin.vo.CountActivityVo;
import com.shp.web.admin.vo.CountClubVo;
import com.shp.web.admin.vo.CountNewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private NewsDao newsDao;

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
    //查询总数
    @Override
    public int dataTableCount(Club club) {
        return clubDao.dataTableCount(club);
    }
    //添加（新增+更新）
    @Override
    public BaseResult save(Club club) {
        String beanValidator = BeanValidator.validator(club);
        //验证不通过
        if(beanValidator!=null){
            return BaseResult.fail(beanValidator);
        }
        //通过验证
        else {
            if(club.getClubId()==null){
                clubDao.save(club);
            }
            else{
                clubDao.update(club);
            }
        }
        return BaseResult.success("保存用户信息成功");
    }
    //删除(批量更新状态)
    @Override
    public void deleteMulti(String[] idArray) {
        clubDao.deleteMulti(idArray);
    }

    //社团一览
    @Override
    public PageInfo<CountClubVo> countClub(int start, int length, int draw, Club club) {
        int count = clubDao.dataTableCount(club);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("club",club);
        List<Club> clubList = clubDao.dataTableSearch(params);
        List<CountActivityVo> countActivityVoList = activityDao.selectCount();
        List<CountNewsVo> countNewsVoList = newsDao.selectCount();
        List<CountClubVo> countClubVos = new ArrayList<>();
        for (int i = 0; i < clubList.size(); i++) {
            CountClubVo countClubVo = new CountClubVo();
            countClubVo.setClubId(clubList.get(i).getClubId());
            countClubVo.setClubName(clubList.get(i).getName());
            countClubVo.setStar(clubList.get(i).getStar());
            for (int j = 0; j < countActivityVoList.size(); j++) {
                if(clubList.get(i).getClubId().equals(countActivityVoList.get(j).getClubId())){
                    countClubVo.setActivityCount(countActivityVoList.get(j).getCountActivity());
                }
            }
            for (int k = 0; k < countNewsVoList.size(); k++) {
                if(clubList.get(i).getClubId().equals(countNewsVoList.get(k).getClubId())){
                    countClubVo.setNewsCount(countNewsVoList.get(k).getCountNews());
                }
            }
            countClubVos.add(countClubVo);
        }
        for (int m = 0; m < countClubVos.size(); m++) {
            if(countClubVos.get(m).getActivityCount()==null){
                countClubVos.get(m).setActivityCount(0);
            }
            if(countClubVos.get(m).getNewsCount()==null){
                countClubVos.get(m).setNewsCount(0);
            }
        }
        Collections.sort(countClubVos, new Comparator<CountClubVo>() {
            @Override
            public int compare(CountClubVo o1, CountClubVo o2) {
                if(o1.getActivityCount()==o2.getActivityCount()){
                    //相等返回0
                    if(o1.getNewsCount()==o2.getNewsCount()){
                        return 0;
                    }
                    //1>2,降序返回-1，升序返回1
                    if(o1.getNewsCount()>o2.getNewsCount()){
                        return -1;
                    }
                    //1<2,降序返回1,升序返回-1
                    else {
                        return 1;
                    }
                }
                if (o1.getActivityCount()>o2.getActivityCount()){
                    return -1;
                }
                return 1;
            }
        });

        PageInfo<CountClubVo> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(countClubVos);
        return pageInfo;
    }
    //添加用户进相应社团======这个方法后面可以删除，没有使用
    @Override
    public BaseResult save(Long clubId, Long userId) {
        if(clubId==null||userId==null){
            return BaseResult.fail("社团ID或用户为空");
        }
        else{
            clubDao.saveClubUser(clubId,userId);
        }
        return BaseResult.success("保存用户信息成功");
    }

}
