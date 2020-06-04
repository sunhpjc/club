package com.shp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class AdminUser implements Serializable {
    private Long adminId;
    private Long clubId;
    private String clubName;
    @Email
    private String adminEmail;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "电话格式不正确")
    private String adminPhone;
    @JsonIgnore
    @Length(min = 6,max=20,message = "密码应介于6~20位之间")
    private String adminPassword;
    private String img;
    @Length(min = 1,max = 10,message = "姓名应在1~10个字符之间")
    private String realName;
    private String sex;
    @NotEmpty
    private String possition;
    @Length(min = 12,max = 12,message = "学号格式不正确")
    private String number;
    @NotEmpty
    private String college;
    @NotEmpty
    private String major;
    private Integer adminStatus;
    private Integer adminType;
    private String createtime;
    private String updatetime;
}
