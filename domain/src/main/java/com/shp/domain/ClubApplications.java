package com.shp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/10 16:40
 */
@Data
public class ClubApplications implements Serializable {
    private Long clubApplicationId;
    private Long clubId;
    private Long userId;
    private String realName;
    private Integer clubApplicationType;
    private String clubApplicationDesc;
    private Integer clubApplicationStatus;
    private String createtime;
    private String updatetime;

    private String userEmail;
    private String userPhone;
    private String sex;
    private String number;
    private String college;
    private String major;

}
