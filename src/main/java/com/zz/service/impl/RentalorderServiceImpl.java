package com.zz.service.impl;
import com.zz.common.enhance.MpPage;
import com.zz.common.enhance.MpQueryWrapper;
import com.zz.pojo.query.RentalOrderQuery;
import com.zz.pojo.vo.RentalOrderVo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.RentalorderMapper;
import com.zz.pojo.po.Rentalorder;
import com.zz.service.RentalorderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * (Rentalorder)表服务实现类
 *
 * @author 秋刀鱼
 * @since 2023-12-22 19:39:10
 */
@Service
@Transactional
public class RentalorderServiceImpl extends ServiceImpl<RentalorderMapper, Rentalorder> implements RentalorderService {

    @Override
    public Rentalorder agree(RentalOrderVo rentalOrderVo) {
        Rentalorder rentalorder = new Rentalorder();
        rentalorder.setClientIdNumber(rentalOrderVo.getClientIdNumber());
        rentalorder.setClientName(rentalOrderVo.getClientName());
        rentalorder.setClientDriverNumber(rentalOrderVo.getClientDriverNumber());
        rentalorder.setClientId(rentalOrderVo.getClientId());
        rentalorder.setRentalTime(rentalOrderVo.getRentalTime());
        rentalorder.setCarId(rentalOrderVo.getCarId());
        rentalorder.setRentalCount(rentalOrderVo.getRentalCount());
        rentalorder.setRentalMoney(rentalOrderVo.getRentalMoney());
        rentalorder.setRentalDay(rentalOrderVo.getRentalDay());
        /**
         * 实现让日期加上租车天数
         */
        LocalDate date = LocalDate.parse(rentalOrderVo.getRentalTime());
        LocalDate newDate = date.plusDays(rentalOrderVo.getRentalDay());
        String returnTime = newDate.toString();
        rentalorder.setReturnTime(returnTime);
        //1代表成功
        rentalorder.setStatus(1);
        return rentalorder;
    }
    public Rentalorder refuse(RentalOrderVo rentalOrderVo) {
        Rentalorder rentalorder = new Rentalorder();
        rentalorder.setClientIdNumber(rentalOrderVo.getClientIdNumber());
        rentalorder.setClientName(rentalOrderVo.getClientName());
        rentalorder.setClientDriverNumber(rentalOrderVo.getClientDriverNumber());
        rentalorder.setClientId(rentalOrderVo.getClientId());
        rentalorder.setRentalTime(rentalOrderVo.getRentalTime());
        rentalorder.setCarId(rentalOrderVo.getCarId());
        rentalorder.setRentalCount(rentalOrderVo.getRentalCount());
        rentalorder.setRentalMoney(rentalOrderVo.getRentalMoney());
        rentalorder.setRentalDay(rentalOrderVo.getRentalDay());
        /**
         * 实现让日期加上租车天数
         */
        LocalDate date = LocalDate.parse(rentalOrderVo.getRentalTime());
        LocalDate newDate = date.plusDays(rentalOrderVo.getRentalDay());
        String returnTime = newDate.toString();
        rentalorder.setReturnTime(returnTime);
        //1代表成功,0代表失败
        rentalorder.setStatus(0);
        System.out.println(rentalorder);
        return rentalorder;
    }

    @Override
    public void list(RentalOrderQuery query) {
        MpPage<Rentalorder> page=new MpPage<>(query);
        MpQueryWrapper<Rentalorder> wrapper=new MpQueryWrapper();
        wrapper.likes(query.getKeyword(),Rentalorder::getCarId,Rentalorder::getClientName);
        wrapper.orderByDesc(Rentalorder::getId);
        baseMapper.selectPage(page,wrapper).updateQuery();
    }
}

