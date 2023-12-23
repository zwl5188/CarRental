package com.zz.controller;

import com.zz.common.util.Rs;
import com.zz.pojo.po.Rentalapply;
import com.zz.pojo.query.RentalApplyQuery;
import com.zz.pojo.result.CodeMsg;
import com.zz.pojo.result.R;
import com.zz.pojo.vo.RentalApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.zz.service.RentalapplyService;
import org.springframework.web.bind.annotation.*;
/**
 * (Rentalapply)表控制层
 *
 * @author 秋刀鱼
 * @since 2023-12-21 17:55:19
 */
@RestController
@RequestMapping("/rentalApplys")
public class RentalapplyController {
    /**
     * 服务对象
     */
    @Autowired
    private RentalapplyService rentalapplyService;

    @RequestMapping("save")
    public R saveAll(RentalApplyVo rentalApplyVo){
        Rentalapply rentalapply = rentalapplyService.saveAll(rentalApplyVo);
        rentalapplyService.saveOrUpdate(rentalapply);
        return Rs.ok(CodeMsg.OPERATE_OK);
    }

    @RequestMapping("/list")
    public R list(RentalApplyQuery query){
        rentalapplyService.list(query);
        return Rs.ok(query);
    }
}

