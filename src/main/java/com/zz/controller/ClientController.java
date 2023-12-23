package com.zz.controller;




import org.springframework.beans.factory.annotation.Autowired;
import com.zz.pojo.po.Client;
import com.zz.service.ClientService;
import org.springframework.web.bind.annotation.*;





/**
 * (Client)表控制层
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:31:27
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    /**
     * 服务对象
     */
    @Autowired
    private ClientService clientService;

   
}

