package com.zz.pojo.vo;/*
    @Author:秋刀鱼
    @Data：2023-12-23 14:35
    @Description:接受页面传回的登录对象
    @PackageName:com.zz.pojo.vo
*/

import lombok.Data;

@Data
public class LoginVo {
    private String username;
    private String password;
    private String role;
}
