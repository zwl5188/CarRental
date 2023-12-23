package com.zz.controller;/*
    @Author:秋刀鱼
    @Data：2023-12-20 11:00
    @Description: 删除和添加方法的通用类
    @PackageName:com.zz.controller
*/

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.common.util.Rs;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;


@Validated
public abstract class BaseController<T> {
    protected abstract IService<T> getService();
    @RequestMapping("remove")
    public R remove(@NotBlank(message = "id不能为空")String id){
        if(getService().removeByIds(Arrays.asList(id.split(",")))){
            return Rs.ok(CodeMsg.REMOVE_OK);
        }else{
            return Rs.raise(CodeMsg.REMOVE_ERROR);
        }
    }
    //通用的添加方法
    @RequestMapping("/save")
    public R save(@Valid T entity){
        if (getService().saveOrUpdate(entity)){
            return Rs.ok(CodeMsg.SAVE_OK);
        }else {
            return Rs.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
