package com.huwo.datahospice.strategy;

import com.alibaba.fastjson.JSON;
import com.huwo.data.upstream.api.common.IPCTypeEnum;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.utils.KafkaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class IBasicAndOrderStrategy implements InitializingBean {


    //数据上报
    public void handleAndSendData(DuBody duBody) {

        //处理保存数据
        DuBody newDubody = handleAndSaveData(duBody);

        String ipcType = duBody.getIpcType();

        if (IPCTypeEnum.DRIVER.getType().equals(ipcType)
                || IPCTypeEnum.VEHICLE.getType().equals(ipcType)
                || IPCTypeEnum.VEHICLE_INSURANCE.getType().equals(ipcType)
                || IPCTypeEnum.PASSENGER.getType().equals(ipcType)) {
            return;
        }
        //发送数据
        sendMessage(newDubody);
    }


    /**
     * @return
     * @Description: 处理数据和存储数据
     * @Author: liuchang
     * @Date: 2022-10-25 14:01
     * @Param: [duBody]
     * @Return: void
     */
    protected abstract DuBody handleAndSaveData(DuBody duBody);


    protected void sendMessage(DuBody duBody) {
        try {
            String topic = IPCTypeEnum.getTopicByType(duBody.getIpcType());
            String finalTopic = "upstream.liuchang." + topic;
            KafkaUtils.sendMessage(JSON.toJSONString(duBody), finalTopic);
            log.info("发送数据成功，发送topic为{}，发送数据为{}", finalTopic, JSON.toJSONString(duBody));
        } catch (Exception e) {
            log.error("lx-datahospice.liuchang出错数据为{}", JSON.toJSONString(duBody));
        }
    }



}
