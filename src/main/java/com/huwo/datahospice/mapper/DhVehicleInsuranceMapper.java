package com.huwo.datahospice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.domain.DhVehicleInsurance;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:22
 */
@Mapper
public interface DhVehicleInsuranceMapper extends BaseMapper<DhVehicleInsurance> {
    void upsert(DhVehicleInsurance dhVehicleInsurance);

    DhVehicleInsurance selectByChannelAndVehicleNoAndAddress(String channel, String vehicleNo, Integer address);
}
