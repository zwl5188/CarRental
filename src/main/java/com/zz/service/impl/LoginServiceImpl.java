package com.zz.service.impl;/*
    @Author:秋刀鱼
    @Data：2023-12-23 15:18
    @Description: 
    @PackageName:com.zz.service.impl
*/

import com.zz.common.util.Rs;
import com.zz.pojo.po.Admin;
import com.zz.pojo.po.Client;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.vo.LoginVo;
import com.zz.service.AdminService;
import com.zz.service.ClientService;
import com.zz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private boolean flag=false;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClientService clientService;
    @Override
    public boolean login(LoginVo loginVo) {
        String role=loginVo.getRole();
        if (role.equals("admin")) {
            Admin admin = adminService.list(loginVo);
            if (admin != null) {
                flag = true;
            } else {
                flag =false;
            }

        }
        else if (role.equals("client")){
            Client client = clientService.list(loginVo);
            if (client != null){
                flag = true;
            }else {
                flag =false;
            }
        }
        return flag;
    }
}
