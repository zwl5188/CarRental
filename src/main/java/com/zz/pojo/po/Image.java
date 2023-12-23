package com.zz.pojo.po;/*
    @Author:秋刀鱼
    @Data：2023-12-20 16:11
    @Description: 图片
    @PackageName:com.zz.pojo.po
*/

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zz.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class Image {
    private Long id;
    private String uri;
    @ForeignField(Car.class)
    private Long ownerId;
}
