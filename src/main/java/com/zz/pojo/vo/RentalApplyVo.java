package com.zz.pojo.vo;/*
    @Author:秋刀鱼
    @Data：2023-12-21 17:15
    @Description: 
    @PackageName:com.zz.pojo.vo
*/

import lombok.Data;

@Data
public class RentalApplyVo {
    private Integer id;
    private String clientDriverNumber;
    private String rentalTime;
    private Integer rentalCount;
    private Integer rentalDay;
    private String clientIdNumber;
    private String clientName;
}
