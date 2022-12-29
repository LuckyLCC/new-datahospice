package com.huwo.datahospice.strategy.basic;

import com.alibaba.fastjson.JSONObject;
import com.huwo.data.upstream.api.util.RTimeUtil;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 网约车平台公司基本信息接口
 * @Author: liuchang
 * @CreateTime: 2022-10-14  14:53
 */

@Component
public class BaseInfoVehicleTotalMileStrategy extends IBasicAndOrderStrategy {

    @Autowired
    private BasicQualityService basicQualityService;


    @Override
    protected DuBody handleAndSaveData(DuBody duBody) {


        return duBody;

    }

    private DuBasicQuality covertToDuBasicQuality(String ipcType, String channel, JSONObject jsonObject) {
        DuBasicQuality basicQuality = new DuBasicQuality();
        basicQuality.setIpcType(ipcType);
        basicQuality.setChannel(channel);
        basicQuality.setStorageTime(RTimeUtil.time2Long());
        basicQuality.setId(jsonObject.getString("id"));
        basicQuality.setData(jsonObject.toString());
        basicQuality.setAddress(jsonObject.getString("address"));

        basicQuality.setVehicleNo(jsonObject.getString("vehicleNo"));

        return basicQuality;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        StrategyFactory.register("baseInfoVehicleTotalMile", this);
    }
}
