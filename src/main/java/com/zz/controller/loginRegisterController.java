package com.zz.controller;/*
    @Author:秋刀鱼
    @Data：2023-12-23 14:31
    @Description: 登录注册控制类
    @PackageName:com.zz.controller
*/


import com.zz.common.util.Rs;
import com.zz.pojo.po.Admin;
import com.zz.pojo.po.Client;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.result.R;
import com.zz.pojo.vo.LoginVo;
import com.zz.service.AdminService;
import com.zz.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginRegister")
public class loginRegisterController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClientService clientService;
    //登录控制方法
    @RequestMapping("/login")
    public R login(@RequestBody LoginVo loginVo){
            String role=loginVo.getRole();
            if (role.equals("admin")) {
                Admin admin = adminService.list(loginVo);
                if (admin != null) {
                   return Rs.ok(CodeMsg.ADMIN_LOGIN_SUCCESS);
                } else {
                   return Rs.error(CodeMsg.LOGIN_ERROR.getMsg());
                }
            }
            else if (role.equals("client")) {
                Client client = clientService.list(loginVo);
                if (client != null) {
                   return Rs.ok(CodeMsg.CLIENT_LOGIN_SUCCESS);
                } else {
                   return Rs.error(CodeMsg.LOGIN_ERROR.getMsg());
                }
            }
            return Rs.ok();
        }
}
