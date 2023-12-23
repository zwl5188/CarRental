package com.zz.service.impl;
import com.zz.common.enhance.MpPage;
import com.zz.common.enhance.MpQueryWrapper;
import com.zz.common.util.Uploads;
import com.zz.pojo.po.Image;
import com.zz.pojo.query.CarQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.CarMapper;
import com.zz.pojo.po.Car;
import com.zz.service.CarService;
import org.springframework.stereotype.Service;

/**
 * (Car)表服务实现类
 *
 * @author 秋刀鱼
 * @since 2023-12-21 08:23:40
 */
@Service
@Transactional
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Override
    public boolean saveOrUpdate(Car car, Image image) {
        if (image != null){
            //删除旧的照片
            Image image1=new Image();
            image1.setUri(car.getImage());
            Uploads.remove(image1);
            car.setImage(image.getUri());
        }
        return super.saveOrUpdate(car);
    }
    //设置只读方法
    @Transactional(readOnly = true)
    @Override
    public void list(CarQuery query) {
        MpPage<Car> page=new MpPage<>(query);
        MpQueryWrapper<Car> wrapper=new MpQueryWrapper<>();
        wrapper.likes(query.getKeyword(),Car::getCarType,Car::getCarBrand,Car::getType);
        wrapper.orderByDesc(Car::getId);
        baseMapper.selectPage(page,wrapper).updateQuery();
    }

    @Override
    public Car listById(Integer id) {
       return baseMapper.selectById(id);
    }

}

