package com.zz.service.impl;
import com.zz.pojo.vo.LoginVo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.AdminMapper;
import com.zz.pojo.po.Admin;
import com.zz.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * (Admin)表服务实现类
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:39:59
 */
@Service
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin list(LoginVo loginVo) {
        String username=loginVo.getUsername();
        String password=loginVo.getPassword();
        Admin admin = adminMapper.selectByUsername(username, password);
        return admin;
    }
}

