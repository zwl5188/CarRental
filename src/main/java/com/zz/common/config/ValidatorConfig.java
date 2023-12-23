package com.zz.common.config;/*
    @Author:秋刀鱼
    @Data：2023-12-13 9:02
    @Description: 设置后端校验快速失败的配置类
    @PackageName:com.zz.common
*/

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator(){
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }
}
