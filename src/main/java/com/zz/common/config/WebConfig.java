package com.zz.common.config;/*
    @Author:秋刀鱼
    @Data：2023-12-19 19:52
    @Description: 
    @PackageName:com.zz.common.config
*/

import com.zz.common.prop.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;


@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Properties properties;
    @Value("${prop.upload.uploadFullPath}")
    private String uploadFile;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + uploadFile + "/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        // /**表示对所有的路径开发全局跨域访问权限
        registry.addMapping("/**")
                //开发哪些端口、ip、域名的权限
                .allowedOrigins(properties.getWeb().getCorsOrigins())
                //是否允许发送cookie信息
                .allowCredentials(true)
                //哪些http方法允许跨域访问
                .allowedMethods("GET","POST");
    }


}
