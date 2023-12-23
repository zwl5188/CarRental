package com.zz.common.util;/*
    @Author:秋刀鱼
    @Data：2023-12-20 15:49
    @Description: 文件上传的控制类
    @PackageName:com.zz.common.util
*/

import com.zz.common.prop.Properties;
import com.zz.pojo.po.Image;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class Uploads {
    private static Properties.Upload upload;
    static {
        upload=Properties.get().getUpload();
    }
    public static Image uploadImage(MultipartFile multipartFile) throws IOException {
        //目录相对
        String dirPath=upload.getImageRelativePath();
        String filepath=uploadFile(multipartFile,dirPath);
        if (filepath == null){
            return null;
        }
        //返回图片对象
        Image image= new Image();
        image.setUri(filepath);
        return image;
    }
    //设置文件上传属性
    public static String uploadFile(MultipartFile multipartFile,String dir) throws IOException {
        if (multipartFile == null || multipartFile.getSize() == 0) return null;
            //文件扩展名
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            //文件名
            String filename = UUID.randomUUID() + "." + extension;
            //文件路径(相对)
            String filepath = dir + filename;
            //文件路径（绝对）
            String fullFilepath = upload.getBasePath() + filepath;
            File file = new File(fullFilepath);
            //创建文件夹
                FileUtils.forceMkdirParent(file);
            //剪切
            multipartFile.transferTo(file);
            //返回图片对象
            return filepath;

    }
    public static void remove(String uri){
        if (StringUtils.isEmpty(uri)) return;
        String path=upload.getBasePath()+uri;
        FileUtils.deleteQuietly(new File(path));
    }
    public static void remove(Image image){
        if (image == null) return;
        remove(image.getUri());
    }
    public static void remove(List<Image> images){
        if (images == null) return;
        for (Image image : images) {
            remove(image);
        }
    }
}
