package com.shp.domain;

import lombok.Data;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/22 11:26
 */
@Data
public class Place {
    private Long placeId;
    private String name;
    private String placeStatus;
    private String createtime;
    private String updatetime;
}
