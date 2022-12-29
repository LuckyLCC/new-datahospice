package com.huwo.datahospice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DhVehicle;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:03
 */
public interface DhVehicleService extends IService<DhVehicle> {

    int upsert(DhVehicle dhVehicle);

    DhVehicle selectByChannelAndVehicleNoAndAddress(String channel,String vehicleNo,Integer address);
}
