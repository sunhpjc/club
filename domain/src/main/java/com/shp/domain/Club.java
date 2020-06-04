package com.shp.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class Club implements Serializable {
    private Long clubId;
    @Length(min = 3,max = 10,message = "社团名称应在3~10个字符之间")
    private String name;
    @Email
    private String email;
    private String logo;
    @Length(max = 100,message = "社团宣言应在100个字符以内")
    private String clubDesc;
    private String foundtime;
    @Length(max = 10,message = "创建者名字应在10个字符以内")
    private String founder;
    private Integer star;
    private Integer clubStatus;
    private Integer clubType;
    private String createtime;
    private String updatetime;
}
