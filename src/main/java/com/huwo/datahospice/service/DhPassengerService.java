package com.huwo.datahospice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwo.datahospice.domain.DhPassenger;
import com.huwo.datahospice.domain.DhVehicleInsurance;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:32
 */
public interface DhPassengerService extends IService<DhPassenger> {
    DhPassenger selectByChannelAndPassengerPhone(String channel, String passengerPhone);

    void upsert(DhPassenger dataFrom);

}
