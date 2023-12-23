package com.zz.common.enhance;/*
    @Author:秋刀鱼
    @Data：2023-12-21 8:54
    @Description: 
    @PackageName:com.zz.common.enhance
*/

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.pojo.query.PageQuery;

public class MpPage<T> extends Page<T> {
    private PageQuery query;
    public MpPage(PageQuery query){
        super(query.getPage(),query.getSize());
        this.query=query;
    }
    public void updateQuery(){
        query.setPage(getCurrent());
        query.setPages(getPages());
        query.setCount(getTotal());
        query.setData(getRecords());
        query.setSize(getSize());

    }
}
