package com.zz.pojo.po;

import lombok.Data;
@Data
public class Client  {
    //客户Id
    private Integer id;
    //客户账号
    private String username;
    //客户密码
    private String password;
    //客户身份证号码
    private String clientIdNumber;
    //客户姓名
    private String clientName;
    //客户驾驶证号码
    private String clientDriverName;
    //客户电话号码
    private String tel;

}

