package com.shp.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户社团关联表
 * @Author: sunhp
 * @Date: 2020/4/15 8:43
 */
@Data
public class UserClub implements Serializable {
    private Long clubId;
    private Long userId;
}
