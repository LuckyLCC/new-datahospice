package com.huwo.datahospice.service.event;

import com.alibaba.fastjson.JSON;
import com.huwo.datahospice.common.DuBody;
import com.huwo.datahospice.factory.StrategyFactory;
import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZhangAihua
 * @date 2021/1/22 0022 15:43
 */
@Service
@Slf4j
public class BasicQualityEventService {


    public void execute(String topic, String eventData) {

        DuBody duBody = JSON.parseObject(eventData, DuBody.class);
        String ipcType = duBody.getIpcType();

        IBasicAndOrderStrategy strategy = StrategyFactory.getStrategy(ipcType);
        strategy.handleAndSendData(duBody);


    }


}
