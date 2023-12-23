package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.pojo.po.Client;
import org.apache.ibatis.annotations.Select;

/**
 * (Client)表数据库访问层
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:31:27
 */
public interface ClientMapper extends BaseMapper<Client> {
    @Select("select * from client where username=#{username} and password=#{password}")
    Client selectByUsername(String username, String password);
    @Select("select * from client where client_id_number=#{clientIdNumber}")
    Client selectByIdNumber(String clientIdNumber);
}
