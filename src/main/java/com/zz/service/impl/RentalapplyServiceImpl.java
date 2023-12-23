package com.zz.service.impl;
import com.zz.common.enhance.MpPage;
import com.zz.common.enhance.MpQueryWrapper;
import com.zz.pojo.po.Car;
import com.zz.pojo.po.Client;
import com.zz.pojo.query.RentalApplyQuery;
import com.zz.pojo.vo.RentalApplyVo;
import com.zz.service.CarService;
import com.zz.service.ClientService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.RentalapplyMapper;
import com.zz.pojo.po.Rentalapply;
import com.zz.service.RentalapplyService;
import org.springframework.stereotype.Service;

/**
 * (Rentalapply)表服务实现类
 *
 * @author 秋刀鱼
 * @since 2023-12-21 17:55:19
 */
@Service
@Transactional
public class RentalapplyServiceImpl extends ServiceImpl<RentalapplyMapper, Rentalapply> implements RentalapplyService {
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;
    @Override
    public Rentalapply saveAll(RentalApplyVo rentalApplyVo) {
        Rentalapply rentalapply=new Rentalapply();
        Client client = clientService.listByIdNumber(rentalApplyVo.getClientIdNumber());
        Integer carId = rentalApplyVo.getId();
        Car car = carService.listById(carId);
        rentalapply.setClientDriverNumber(rentalApplyVo.getClientDriverNumber());
        rentalapply.setRentalTime(rentalApplyVo.getRentalTime());
        rentalapply.setCarId(carId);
        rentalapply.setDayMoney(car.getDayMoney());
        rentalapply.setRentalCount(rentalApplyVo.getRentalCount());
        rentalapply.setRentalDay(rentalApplyVo.getRentalDay());
        rentalapply.setClientIdNumber(rentalApplyVo.getClientIdNumber());
        Integer rentalMoney=(rentalApplyVo.getRentalCount())*(rentalApplyVo.getRentalCount())*(car.getDayMoney());
        rentalapply.setRentalMoney(rentalMoney);
        rentalapply.setClientName(rentalApplyVo.getClientName());
        rentalapply.setCarName(car.getCarName());
        rentalapply.setClientId(client.getId());
        return rentalapply;
    }

    @Override
    public void list(RentalApplyQuery query) {
        MpPage<Rentalapply> page=new MpPage<>(query);
        MpQueryWrapper<Rentalapply> wrapper=new MpQueryWrapper<>();
        wrapper.likes(query.getKeyword(),Rentalapply::getCarName);
        wrapper.orderByDesc(Rentalapply::getId);
        baseMapper.selectPage(page,wrapper).updateQuery();
    }

}

