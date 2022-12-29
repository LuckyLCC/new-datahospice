package com.huwo.datahospice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwo.datahospice.domain.DhPassenger;
import com.huwo.datahospice.domain.DhVehicleInsurance;
import com.huwo.datahospice.mapper.DhPassengerMapper;
import com.huwo.datahospice.mapper.DhVehicleInsuranceMapper;
import com.huwo.datahospice.service.DhPassengerService;
import com.huwo.datahospice.service.DhVehicleInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:32
 */
@Service
public class DhPassengerServiceImpl extends ServiceImpl<DhPassengerMapper, DhPassenger> implements DhPassengerService {


    @Autowired
    private DhPassengerMapper dhPassengerMapper;

    @Override
    public DhPassenger selectByChannelAndPassengerPhone(String channel, String passengerPhone) {
        return dhPassengerMapper.selectByChannelAndPassengerPhone(channel,passengerPhone);
    }

    @Override
    public void upsert(DhPassenger dataFrom) {
        dhPassengerMapper.upsert(dataFrom);
    }
}
