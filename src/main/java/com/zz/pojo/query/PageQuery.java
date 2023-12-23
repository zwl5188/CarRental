package com.zz.pojo.query;/*
    @Author:秋刀鱼
    @Data：2023-12-05 15:52
    @Description: 
    @PackageName:com.zz.pojo.query
*/

import lombok.Data;

import java.util.List;

@Data
public class PageQuery {
    private long page;
    private long size;
    private List<?> data;
    private long count;
    private long pages;

    public long getPage() {
        return Math.max(page,1);
    }

    public long getSize() {
        return size <1 ? 10:size;
    }
}
