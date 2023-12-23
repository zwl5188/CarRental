package com.zz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.po.Car;
import com.zz.pojo.po.Image;
import com.zz.pojo.query.CarQuery;

/**
 * (Car)表服务接口
 *
 * @author 秋刀鱼
 * @since 2023-12-21 08:23:40
 */
public interface CarService extends IService<Car> {
    boolean saveOrUpdate(Car car, Image image);

    void list(CarQuery query);

    Car listById(Integer id);
}

