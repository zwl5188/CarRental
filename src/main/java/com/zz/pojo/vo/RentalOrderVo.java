package com.zz.pojo.vo;/*
    @Author:秋刀鱼
    @Data：2023-12-22 19:35
    @Description:前端返回的租车订单表的数据
    @PackageName:com.zz.pojo.vo
*/

import lombok.Data;

@Data
public class RentalOrderVo {
    private Integer id;
    private Integer carId;
    private String carName;
    private String clientDriverNumber;
    private Integer clientId;
    private String clientIdNumber;
    private String clientName;
    private Integer dayMoney;
    private Integer rentalCount;
    private Integer rentalDay;
    private Integer rentalMoney;
    private String rentalTime;
}
