package com.shp.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/20 8:52
 */
@Data
public class Notice {
    private Long noticesId;
    private Long clubId;
    @Length(min = 1,max=10,message = "标题长度应该介于1~10之间")
    private String noticesTitle;
    private String noticesContent;
    private String createtime;
    private String updatetime;
}
