package com.zz.service;/*
    @Author:秋刀鱼
    @Data：2023-12-23 15:18
    @Description: 
    @PackageName:com.zz.service
*/

import com.zz.pojo.vo.LoginVo;

public interface LoginService {
    boolean login(LoginVo loginVo);
}
