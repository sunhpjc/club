package com.shp.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Data
public class Finance implements Serializable {
    private Long financeId;
    private Long clubId;
    private String clubName;
    private Double financeCount;
    private Double income;
    private Double expend;
    private String financeDesc;
    private String createtime;
}
