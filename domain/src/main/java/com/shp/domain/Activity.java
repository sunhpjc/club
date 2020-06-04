package com.shp.domain;

import lombok.Data;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/19 12:52
 */
@Data
public class Activity {
    private Long activityId;
    private Long placeId;
    private String placeName;
    private Long clubId;
    private String name;
    private String time;
    private String place;
    private String content;
    private String createtime;
    private String updatetime;
}
