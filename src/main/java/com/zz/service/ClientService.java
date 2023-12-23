package com.zz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.po.Client;
import com.zz.pojo.vo.LoginVo;

/**
 * (Client)表服务接口
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:31:27
 */
public interface ClientService extends IService<Client> {

    Client list(LoginVo loginVo);

    Client listByIdNumber(String ClientIdNumber);
}

