package com.shp.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class News implements Serializable {
    private Long newsId;
    private Long clubId;
    private String name;
    private String newsTitle;
    private String newsContent;
    private String newsLink;
    private Integer newsStatus;
    private String createtime;
    private String updatetime;
}
