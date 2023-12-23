package com.zz.common.Exception;/*
    @Author:秋刀鱼
    @Data：2023-12-06 15:34
    @Description: 自定义抛出异常
    @PackageName:com.zz.common.Exception
*/
import com.zz.pojo.result.CodeMsg;
import lombok.Data;

@Data
public class CommonException extends RuntimeException{
    private int code;
    public CommonException(){
        this(CodeMsg.BAD_REQUEST.getCode(),null);
    }
    public CommonException(String msg){
        this(msg,null);
    }
    public CommonException(int code,String msg){
        this(code,msg,null);
    }
    public CommonException(String msg,Throwable cause){
        this(CodeMsg.BAD_REQUEST.getCode(),msg,cause);
    }
    public CommonException(int code,String msg,Throwable cause){
        super(msg,cause);
        this.code=code;
    }
    public CommonException(CodeMsg codeMsg,Throwable cause){
        this(codeMsg.getCode(),codeMsg.getMsg(),cause);
    }

    public int getCode() {
        return code;
    }

    public CommonException(CodeMsg codeMsg){
        this(codeMsg,null);
    }
}
