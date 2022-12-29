package com.huwo.datahospice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.domain.DhVehicleInsurance;

public interface DhVehicleInsuranceService extends IService<DhVehicleInsurance> {
    DhVehicleInsurance selectByChannelAndVehicleNoAndAddress(String channel, String vehicleNo, Integer address);

    void upsert(DhVehicleInsurance dhFromDB);
}
