package com.zz.pojo.po;

import lombok.Data;
@Data
public class Rentalorder  {
    //租车订单表Id
    private Integer id;
    //客户身份证号
    private String clientIdNumber;
    //客户名称
    private String clientName;
    //客户驾驶证号码
    private String clientDriverNumber;
    //客户Id
    private Integer clientId;
    //租车时间
    private String rentalTime;
    //车辆Id
    private Integer carId;
    //租车数量
    private Integer rentalCount;
    //租车金额
    private Integer rentalMoney;
    //租赁天数
    private Integer rentalDay;
    //还车时间
    private String returnTime;
    //订单状态
    //1代表同意 0代表拒绝
    private Integer status;

}

