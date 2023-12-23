package com.zz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.po.Rentalapply;
import com.zz.pojo.query.RentalApplyQuery;
import com.zz.pojo.vo.RentalApplyVo;

/**
 * (Rentalapply)表服务接口
 *
 * @author 秋刀鱼
 * @since 2023-12-21 17:55:19
 */
public interface RentalapplyService extends IService<Rentalapply> {

    Rentalapply saveAll(RentalApplyVo rentalApplyVo);

    void list(RentalApplyQuery query);
}

