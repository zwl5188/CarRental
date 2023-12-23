package com.zz.controller;
import com.zz.common.util.Rs;
import com.zz.pojo.query.RentalOrderQuery;
import com.zz.pojo.result.R;
import com.zz.pojo.vo.RentalOrderVo;
import com.zz.service.RentalapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import com.zz.pojo.po.Rentalorder;
import com.zz.service.RentalorderService;
import org.springframework.web.bind.annotation.*;
/**
 * (Rentalorder)表控制层
 *
 * @author 秋刀鱼
 * @since 2023-12-22 19:39:10
 */
@RestController
@RequestMapping("/rentalorders")
public class RentalorderController {
    /**
     * 服务对象
     */
    @Autowired
    private RentalorderService rentalorderService;
    @Autowired
    private RentalapplyService rentalapplyService;
    @RequestMapping("/agree")
    public R agree(@RequestBody RentalOrderVo rentalOrderVo){
        Rentalorder rentalorder = rentalorderService.agree(rentalOrderVo);
        rentalorderService.saveOrUpdate(rentalorder);
        rentalapplyService.removeById(rentalOrderVo.getId());
        return Rs.ok();
    }
    @RequestMapping("/refuse")
    public R refuse(@RequestBody RentalOrderVo rentalOrderVo){
        Rentalorder rentalorder = rentalorderService.refuse(rentalOrderVo);
        rentalorderService.saveOrUpdate(rentalorder);
        rentalapplyService.removeById(rentalOrderVo.getId());
        return Rs.ok();
    }
    @RequestMapping("/list")
    public R list(RentalOrderQuery query){
        rentalorderService.list(query);
        return Rs.ok(query);
    }
}

