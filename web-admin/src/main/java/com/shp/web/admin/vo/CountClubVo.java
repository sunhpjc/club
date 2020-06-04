package com.shp.web.admin.vo;

import lombok.Data;

/**
 * @Description: 社团一览各社团信息总数
 * @Author: sunhp
 * @Date: 2020/3/30 21:37
 */
@Data
public class CountClubVo {
    private Long clubId;
    private String clubName;
    private Integer activityCount;
    private Integer newsCount;
    private Integer star;
}
