package com.zz.pojo.vo;/*
    @Author:秋刀鱼
    @Data：2023-12-20 19:45
    @Description: 
    @PackageName:com.zz.pojo.vo
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarVo{
    private String cover;
    private MultipartFile undefined;
}
