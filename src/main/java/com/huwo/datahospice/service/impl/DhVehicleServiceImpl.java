package com.huwo.datahospice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.mapper.DhDriverMapper;
import com.huwo.datahospice.mapper.DhVehicleMapper;
import com.huwo.datahospice.service.DhDriverService;
import com.huwo.datahospice.service.DhVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:04
 */
@Service
public class DhVehicleServiceImpl extends ServiceImpl<DhVehicleMapper, DhVehicle> implements DhVehicleService {

    @Autowired
    private DhVehicleMapper dhVehicleMapper;
    @Override
    public int upsert(DhVehicle dhVehicle) {
        return dhVehicleMapper.upsert(dhVehicle);
    }

    @Override
    public DhVehicle selectByChannelAndVehicleNoAndAddress(String channel, String vehicleNo, Integer address) {
        return dhVehicleMapper.selectByChannelAndVehicleNoAndAddress(channel,vehicleNo,address);
    }
}
