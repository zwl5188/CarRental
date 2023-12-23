package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.pojo.po.Admin;
import com.zz.pojo.vo.LoginVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (Admin)表数据库访问层
 *
 * @author 秋刀鱼
 * @since 2023-12-23 14:39:59
 */
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin selectByUsername(@Param("username") String username, @Param("password") String password);
}
