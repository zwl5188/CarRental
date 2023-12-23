package com.zz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.po.Admin;
import com.zz.pojo.vo.LoginVo;

/**
 * (Admin)表服务接口
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:39:59
 */
public interface AdminService extends IService<Admin> {

    Admin list(LoginVo loginVo);
}

