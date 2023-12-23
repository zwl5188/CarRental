package com.zz.common.prop;/*
    @Author:秋刀鱼
    @Data：2023-12-19 19:56
    @Description: 配置图片上传的路径以及跨域请求的路径
    @PackageName:com.zz.common.prop
*/

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("prop")
@Component
@Data
public class Properties implements InitializingBean {
    private static Properties properties;
    private Web web;
    private Upload upload;
    private String staticAccess;
    public static Properties get(){
        return properties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        properties =this;
    }
    @Data
    public static class Web{
        private String[] corsOrigins;
    }
    @Data
    public static class Upload{
        private String basePath;
        private String uploadPath;
        private String imagePath;
        private String uploadFullPath;
        public String getImageRelativePath(){
            return getUploadPath()+getImagePath();
        }
        public String getUploadFllPath(){
            return getBasePath()+getUploadPath();
        }
    }


}

