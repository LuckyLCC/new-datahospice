package com.huwo.datahospice.strategy.basic;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huwo.data.upstream.api.biz.DuDriver;
import com.huwo.data.upstream.api.common.ChannelEnum;
import com.huwo.data.upstream.api.util.RTimeUtil;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.service.DhDriverService;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-27  17:19
 */
@Component
public class BaseInfoDriverStrategy extends IBasicAndOrderStrategy {
    @Autowired
    private BasicQualityService basicQualityService;

    @Autowired
    private DhDriverService dhDriverService;


    @Override
    protected DuBody handleAndSaveData(DuBody duBody) {
        String channel = duBody.getChannel();
        String data = duBody.getData();
        Integer address = duBody.getAddress();
        if (ChannelEnum.LX.name().equals(channel) || ChannelEnum.YY.name().equals(channel)) {
            DhDriver dh = JSON.parseObject(data, DhDriver.class);
            DhDriver dhFromDB = dhDriverService.selectByChannelAndLicenseIdAndAddress(channel, dh.getLicenseId(), address);
            if (null != dhFromDB) {
                //todo 赋值需要进一步考虑
                BeanUtils.copyProperties(dh, dhFromDB,"id");
                dhFromDB.setCreateTime(RTimeUtil.time2Long());
                dhDriverService.upsert(dhFromDB);
            } else {
                String id = IdUtil.getSnowflakeNextIdStr();
                dh.setId(id);
                dh.setChannel(channel);
                dhDriverService.upsert(dh);
            }
        }

        return duBody;

    }


    @Override
    public void afterPropertiesSet() throws Exception {

        StrategyFactory.register("baseInfoDriver", this);

    }
}
