package com.shp.web.admin.dao;

import com.shp.domain.Club;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClubDao {
    //通过id查询
    public Club getClubById(Long id);
    //查询所有
    public List<Club> dataTableSearch(Map<String,Object> params);
    //查询总数
    public int dataTableCount(Club club);
    //添加
    public void save(Club club);
    //删除（批量更新状态）
    public void deleteMulti(String[] idArray);
    //修改
    public void update(Club club);

    //查询社团部分信息，用于社团一览
    List<Club> selectClubAll();
    //添加相应用户到社团
    void saveClubUser(Long clubId,Long userId);
}
