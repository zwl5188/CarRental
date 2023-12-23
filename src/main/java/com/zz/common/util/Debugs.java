package com.zz.common.util;/*
    @Author:秋刀鱼
    @Data：2023-12-07 11:27
    @Description: 
    @PackageName:com.zz.common.util
*/

public class Debugs {
    private static final boolean DEBUG= false;
    public static void run(Runnable runnable){
        if (!DEBUG) return;
        if (!DEBUG||runnable==null) return;
        runnable.run();
    }
}
