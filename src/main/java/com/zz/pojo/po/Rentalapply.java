package com.zz.pojo.po;

import lombok.Data;
@Data
public class Rentalapply  {
    //租车申请表Id
    private Integer id;
    //车辆名称
    private String carName;
    //客户驾驶证号
    private String clientDriverNumber;
    //租车时间
    private String rentalTime;
    //车辆Id
    private Integer carId;
    //租车金额
    private Integer rentalMoney;
    //租车数量
    private Integer rentalCount;
    //租赁天数
    private Integer rentalDay;
    //客户身份证号码
    private String clientIdNumber;
    //客户名称
    private String clientName;
    //日租金
    private Integer dayMoney;
    //客户表Id
    private Integer clientId;

}

