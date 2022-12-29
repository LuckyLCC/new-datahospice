package com.huwo.datahospice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DhVehicle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DhVehicleMapper extends BaseMapper<DhVehicle> {

    int upsert(DhVehicle dhVehicle);

    DhVehicle selectByChannelAndVehicleNoAndAddress(String channel, String licenseId, Integer address);
}
