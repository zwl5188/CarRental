package com.zz.pojo.result;/*
    @Author:秋刀鱼
    @Data：2023-12-20 9:34
    @Description: 返回给客户的Json数据
    @PackageName:com.zz.pojo.result
*/

import com.zz.common.enhance.JsonAble;

import java.util.HashMap;

public class R extends HashMap<String,Object> implements JsonAble{
    private static final String K_CODE="code";
    private static final String k_MSG="msg";
    private static final String K_DATA="data";
    private static final int CODE_SUCCESS=CodeMsg.OPERATE_OK.getCode();
    private static final int CODE_ERROR_DEFAULT=CodeMsg.BAD_REQUEST.getCode();
    public R(){
        this(true);
    }
    public R(boolean success){
        this(success,null);
    }
    public R(boolean success,String msg){
        this(success?CODE_SUCCESS:CODE_ERROR_DEFAULT,msg);
    }
    public R(int code,String msg){
        put(K_CODE,code);
        put(k_MSG,msg);
    }
    public R(CodeMsg codeMsg){
        this(codeMsg.getCode(),codeMsg.getMsg());
    }
    public R(String msg,Object data){
        this(data);
        put(k_MSG,msg);
    }
    public R(Object data){
        put(K_CODE,CODE_SUCCESS);
        put(K_DATA,data);
    }
}
