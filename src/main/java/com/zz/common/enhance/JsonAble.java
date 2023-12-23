package com.zz.common.enhance;/*
    @Author:秋刀鱼
    @Data：2023-12-20 9:32
    @Description: 转换成json字符串
    @PackageName:com.zz.common.enhance
*/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonAble {
    default String jsonString() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(this);
    }
}
