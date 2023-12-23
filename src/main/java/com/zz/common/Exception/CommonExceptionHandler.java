package com.zz.common.Exception;
/*
    @Author:秋刀鱼
    @Data：2023-12-06 15:11
    @Description: 异常统一处理
    @PackageName:com.zz.common.Exception
*/

import com.zz.common.util.Debugs;
import com.zz.common.util.Rs;
import com.zz.pojo.result.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CommonExceptionHandler {
//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public R handler(Throwable t) {
//        return Rs.error(t);
//    }
    @ExceptionHandler(Throwable.class)
    public void handler(Throwable t,
                        HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        //设置返回数据的格式
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(400);
        response.getWriter().write(Rs.error(t).jsonString());
       t.printStackTrace();
    }
}
