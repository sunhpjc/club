package com.shp.web.admin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 社团一览活动总数
 * @Author: sunhp
 * @Date: 2020/4/1 20:37
 */
@Data
public class CountActivityVo implements Serializable {
    private Long clubId;
    private Integer countActivity;
}
