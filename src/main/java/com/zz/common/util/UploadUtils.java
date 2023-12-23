package com.zz.common.util;/*
    @Author:秋刀鱼
    @Data：2023-12-21 13:10
    @Description: 图片上传的工具类
    @PackageName:com.zz.common.util
*/

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    //定义一个上传路径，目标路径
    private static final String BASE_PATH="D:\\Project\\IdeaProject\\upload\\img\\";
    //定义浏览器访问路径
    private static final String SERVER_PATH="http://";
    public static String upload(MultipartFile file) throws IOException {
        //获取上传文件的名称
        String fileName=file.getOriginalFilename();
        //为了保证图片在服务器中的名字的唯一性，使用UUID对filename进行改写
        String uuid= UUID.randomUUID().toString().replace("-","");
        //将生成的uuid和filename进行拼接
        String newFileName=uuid+"-"+fileName;
        //创建一个文件实例
        File image = new File(BASE_PATH, newFileName);
        if (!image.exists()){
            image.mkdir();
        }
        file.transferTo(image);
        return null;
    }
}
