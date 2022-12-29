package com.huwo.datahospice.handler;

import com.huwo.datahospice.service.event.BasicQualityEventService;
import com.huwo.datahospice.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-25  09:43
 */
@Slf4j
public class HwBasicEventHandler implements Runnable{

    BasicQualityEventService basicQualityEventService = SpringUtils.getBean(BasicQualityEventService.class);

    private String topic;
    private String sourceData;

    public HwBasicEventHandler(String topic, String sourceData) {
        this.topic = topic;
        this.sourceData = sourceData;
    }
    @Override
    public void run() {
        log.info("灵犀/呼我--->基础/质量数据：" + sourceData);
        basicQualityEventService.execute(topic, sourceData);
    }
}
