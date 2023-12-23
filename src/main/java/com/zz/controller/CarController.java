package com.zz.controller;




import com.zz.common.util.Rs;
import com.zz.common.util.Uploads;
import com.zz.pojo.po.Image;
import com.zz.pojo.query.CarQuery;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import com.zz.pojo.po.Car;
import com.zz.service.CarService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * (Car)表控制层
 *
 * @author 秋刀鱼
 * @since 2023-12-21 08:23:40
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    /**
     * 服务对象
     */
    @Autowired
    private CarService carService;

    @RequestMapping("/saveAll")
    public R saveAll(Car car, MultipartFile undefined) throws IOException {
        Image image = Uploads.uploadImage(undefined);
        if (carService.saveOrUpdate(car,image)){
            return Rs.ok(CodeMsg.SAVE_OK);
        }
        return Rs.raise(CodeMsg.SAVE_ERROR);
    }

    @RequestMapping("/list")
    public R list(CarQuery query){
        carService.list(query);
        return Rs.ok(query);
    }
   
}

