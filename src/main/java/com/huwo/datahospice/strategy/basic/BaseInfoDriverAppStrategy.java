package com.huwo.datahospice.strategy.basic;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huwo.data.upstream.api.biz.DuDriverApp;
import com.huwo.data.upstream.api.util.RTimeUtil;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-27  11:56
 */
@Component
public class BaseInfoDriverAppStrategy extends IBasicAndOrderStrategy {

    @Autowired
    private BasicQualityService basicQualityService;


    @Override
    protected DuBody handleAndSaveData(DuBody duBody) {

        //发送kafka
        String id = IdUtil.getSnowflakeNextIdStr();
        JSONObject jsonObject = JSON.parseObject(duBody.getData());
        jsonObject.put("id", "S" + id);
        duBody.setData(jsonObject.toJSONString());
        //根据不同的ipcType封装成不同的DuBasicQuality

        DuBasicQuality basicQuality = covertToDuBasicQuality(duBody.getIpcType(), duBody.getChannel(), jsonObject);

        // 保存数据
        CompletableFuture.runAsync(() -> basicQualityService.upsert(basicQuality));

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

        DuDriverApp app = JSON.toJavaObject(jsonObject, DuDriverApp.class);
        basicQuality.setPhoneNo(app.getDriverPhone());
        basicQuality.setCertNo(app.getLicenseId());
        return basicQuality;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyFactory.register("baseInfoDriverApp", this);

    }
}
