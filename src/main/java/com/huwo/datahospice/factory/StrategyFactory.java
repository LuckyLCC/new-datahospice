package com.huwo.datahospice.factory;

import com.huwo.datahospice.strategy.IBasicAndOrderStrategy;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-14  14:50
 */

public class StrategyFactory {


    private static final Map<String, IBasicAndOrderStrategy> strategies = new HashMap<>();


    public static IBasicAndOrderStrategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }

    public static  void register(String name, IBasicAndOrderStrategy iStrategy){
        if (!StringUtils.hasText(name) || null == iStrategy) {
           return;
        }
        strategies.put(name,iStrategy);

    }



}
