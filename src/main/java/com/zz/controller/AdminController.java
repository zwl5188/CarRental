package com.zz.controller;




import org.springframework.beans.factory.annotation.Autowired;
import com.zz.pojo.po.Admin;
import com.zz.service.AdminService;
import org.springframework.web.bind.annotation.*;





/**
 * (Admin)表控制层
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:39:58
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

   
}

