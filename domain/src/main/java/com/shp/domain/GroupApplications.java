package com.shp.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class GroupApplications implements Serializable {
    private Long groupApplicationId;
    private Long activityId;
    private String activityName;
    private String activityTime;
    private String activityPlace;
    private String activityContent;
    private Long clubId;
    private String clubName;
    private Long placeId;
    private String placeName;
    private Integer placeStatus;
    private Integer groupApplicationType;
    private String groupApplicationDesc;
    private Integer groupApplicationStatus;
    private String gcreatetime;
    private String gupdatetime;
}
