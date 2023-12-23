package com.zz.pojo.po;

import lombok.Data;
@Data
public class Car  {
    //汽车表Id
    private Long id;
    //车辆名称
    private String carName;
    //车辆编号
    private String carCard;
    //车牌号
    private String carNumber;
    //车辆类型
    private String type;
    //车辆颜色
    private String carColor;
    //车辆剩余数量
    private Integer carCount;
    //车辆燃油类型
    private String carType;
    //日租金
    private Integer dayMoney;
    //排量
    private String displayment;
    //车辆品牌
    private String carBrand;
    //车辆照片
    private String image;

}

