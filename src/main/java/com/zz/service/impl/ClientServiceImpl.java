package com.zz.service.impl;
import com.zz.pojo.vo.LoginVo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.ClientMapper;
import com.zz.pojo.po.Client;
import com.zz.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * (Client)表服务实现类
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:31:27
 */
@Service
@Transactional
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public Client list(LoginVo loginVo) {
        String username=loginVo.getUsername();
        String password=loginVo.getPassword();
        Client client = clientMapper.selectByUsername(username, password);
        return client;
    }

    @Override
    public Client listByIdNumber(String ClientIdNumber) {
        return clientMapper.selectByIdNumber(ClientIdNumber);
    }
}

