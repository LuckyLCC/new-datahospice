package com.huwo.datahospice.strategy.basic;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huwo.data.upstream.api.common.ChannelEnum;
import com.huwo.data.upstream.api.util.RTimeUtil;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.domain.DhVehicleInsurance;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.service.DhVehicleInsuranceService;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 网约车平台公司基本信息接口
 * @Author: liuchang
 * @CreateTime: 2022-10-14  14:53
 */

@Component
public class BaseInfoVehicleInsuranceStrategy extends IBasicAndOrderStrategy {

    @Autowired
    private BasicQualityService basicQualityService;

    @Autowired
    private DhVehicleInsuranceService dhVehicleInsuranceService;


    @Override
    protected DuBody handleAndSaveData(DuBody duBody) {
        String channel = duBody.getChannel();
        String ipcType = duBody.getIpcType();
        String data = duBody.getData();
        Integer address = duBody.getAddress();
        if (ChannelEnum.LX.name().equals(channel) || ChannelEnum.YY.name().equals(channel)) {
            DhVehicleInsurance dh = JSON.parseObject(data, DhVehicleInsurance.class);
            DhVehicleInsurance dhFromDB = dhVehicleInsuranceService.selectByChannelAndVehicleNoAndAddress(channel, dh.getVehicleNo(), address);
            if (null != dhFromDB) {
                //todo 赋值需要进一步考虑
                BeanUtils.copyProperties(dh,dhFromDB);
                dhFromDB.setCreateTime(RTimeUtil.time2Long());
                dhVehicleInsuranceService.upsert(dhFromDB);
            } else {
                String id = IdUtil.getSnowflakeNextIdStr();
                dh.setId(id);
                dhVehicleInsuranceService.upsert(dh);
            }
        }

        return duBody;

    }


    @Override
    public void afterPropertiesSet() throws Exception {

        StrategyFactory.register("baseInfoVehicleInsurance", this);
    }
}
