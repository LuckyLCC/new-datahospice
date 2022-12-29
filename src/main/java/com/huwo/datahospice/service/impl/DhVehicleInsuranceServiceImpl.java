package com.huwo.datahospice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.domain.DhVehicleInsurance;
import com.huwo.datahospice.mapper.DhVehicleInsuranceMapper;
import com.huwo.datahospice.mapper.DhVehicleMapper;
import com.huwo.datahospice.service.DhVehicleInsuranceService;
import com.huwo.datahospice.service.DhVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:21
 */
@Service
public class DhVehicleInsuranceServiceImpl extends ServiceImpl<DhVehicleInsuranceMapper, DhVehicleInsurance> implements DhVehicleInsuranceService {

    @Autowired
    private DhVehicleInsuranceMapper dhVehicleInsuranceMapper;

    @Override
    public DhVehicleInsurance selectByChannelAndVehicleNoAndAddress(String channel, String vehicleNo, Integer address) {
        return dhVehicleInsuranceMapper.selectByChannelAndVehicleNoAndAddress(channel,vehicleNo,address);
    }

    @Override
    public void upsert(DhVehicleInsurance dhVehicleInsurance) {
        dhVehicleInsuranceMapper.upsert(dhVehicleInsurance);
    }
}
