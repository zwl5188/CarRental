package com.zz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.po.Rentalorder;
import com.zz.pojo.query.RentalOrderQuery;
import com.zz.pojo.vo.RentalOrderVo;

/**
 * (Rentalorder)表服务接口
 *
 * @author 秋刀鱼
 * @since 2023-12-22 19:39:10
 */
public interface RentalorderService extends IService<Rentalorder> {

    Rentalorder agree(RentalOrderVo rentalOrderVo);

    Rentalorder refuse(RentalOrderVo rentalOrderVo);

    void list(RentalOrderQuery query);
}

