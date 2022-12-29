package com.huwo.datahospice.strategy.basic;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huwo.data.upstream.api.biz.DuDriver;
import com.huwo.data.upstream.api.common.ChannelEnum;
import com.huwo.data.upstream.api.util.RTimeUtil;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.domain.DhPassenger;
import com.huwo.datahospice.domain.DhVehicle;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.service.DhPassengerService;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-27  17:19
 */
@Component
public class BaseInfoPassengerStrategy extends IBasicAndOrderStrategy {
    @Autowired
    private BasicQualityService basicQualityService;


    @Autowired
    private DhPassengerService dhPassengerService;


    @Override
    protected DuBody handleAndSaveData(DuBody duBody) {
        String channel = duBody.getChannel();
        String data = duBody.getData();
        if (ChannelEnum.LX.name().equals(channel) || ChannelEnum.YY.name().equals(channel)) {
            DhPassenger dh = JSON.parseObject(data, DhPassenger.class);
            DhPassenger dhFromDB = dhPassengerService.selectByChannelAndPassengerPhone(channel, dh.getPassengerPhone());
            if (null != dhFromDB) {
                //todo 赋值需要进一步考虑
                BeanUtils.copyProperties(dh, dhFromDB,"id");
                dhFromDB.setCreateTime(RTimeUtil.time2Long());
                dhPassengerService.upsert(dhFromDB);
            } else {
                String id = IdUtil.getSnowflakeNextIdStr();
                dh.setId(id);
                dh.setChannel(channel);
                dhPassengerService.upsert(dh);
            }
        }
        return duBody;

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        StrategyFactory.register("baseInfoPassenger", this);

    }
}
