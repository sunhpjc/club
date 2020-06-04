package com.shp.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comments implements Serializable {
    private Long commentsId;
    private Long userId;
    private String userName;
    private String realName;
    private String number;
    private String college;
    private String major;
    private Long newsId;
    private String newsTitle;
    private String comments;
    private String cmCreatetime;
}
