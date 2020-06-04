package com.shp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/3 20:13
 */
@Data
public class User implements Serializable {
    private Long userId;
    @Email()
    private String userEmail;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "电话格式不正确")
    private String userPhone;
    @JsonIgnore
    @Length(min = 6,max=20,message = "密码应介于6~20位之间")
    private String userPassword;
    @Length(min = 1,max=10,message = "用户名应介于1~10位之间")
    private String userName;
    private String userImg;
    @Length(min = 1,max = 10,message = "姓名应在1~10个字符之间")
    private String realName;
    @NotEmpty(message = "性别不能为空")
    private String sex;
    @Length(min = 12,max = 12,message = "学号格式不正确")
    private String number;
    @NotEmpty
    private String college;
    @NotEmpty
    private String major;
    private Integer userStatus;
    private String createtime;
    private String updatetime;
}
