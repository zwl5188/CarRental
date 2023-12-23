package com.zz.common.util;/*
    @Author:秋刀鱼
    @Data：2023-12-20 10:28
    @Description:生产R的工具类
    @PackageName:com.zz.common.util
*/

import com.zz.common.Exception.CommonException;
import com.zz.pojo.query.PageQuery;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.result.R;

public class Rs {
    private static final String K_COUNT="count";
    public static R error(String msg){
        return new R(false,msg);
    }
    public static R error(){
        return new R(false);
    }
    public static R error(Throwable t){
        if (t instanceof CommonException){
            CommonException ce= (CommonException) t;
            return new R(ce.getCode(),ce.getMessage());
        }else {
            return error();
        }
    }
    public static R ok(PageQuery query){
        R r = new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }
    public static R ok(Object data){
        return new R(data);
    }
    public static R ok(){
        return new R();
    }
    public static R ok(String msg){
        return new R(true,msg);
    }
    public static R ok(CodeMsg codeMsg){
        return new R(true,codeMsg.getMsg());
    }
    public static R raise(String msg)throws CommonException{
        throw new CommonException(msg);
    }
    public static R raise(CodeMsg codeMsg)throws CommonException{
        throw new CommonException(codeMsg);
    }
}
