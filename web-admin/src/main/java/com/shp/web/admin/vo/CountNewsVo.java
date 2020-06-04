package com.shp.web.admin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 社团一览新闻总数
 * @Author: sunhp
 * @Date: 2020/4/1 20:46
 */
@Data
public class CountNewsVo implements Serializable {
    private Long clubId;
    private Integer countNews;
}
