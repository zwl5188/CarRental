package com.zz.common.enhance;/*
    @Author:秋刀鱼
    @Data：2023-12-21 8:55
    @Description: 查询条件的简单封装类
    @PackageName:com.zz.common.enhance
*/

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

public class MpQueryWrapper<T> extends LambdaQueryWrapper<T> {

    public MpQueryWrapper<T> likes(Object val, SFunction<T,?>...funcs){
        if (val == null) return this;
        String str=val.toString();
        if (str.length() == 0) return this;
        return (MpQueryWrapper<T>) nested(w ->{
            for (SFunction<T,?> func:funcs){
                w.like(func,str).or();
            }
        });
    }
}
