package com.huwo.datahospice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DhPassenger;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-11-01  16:32
 */
@Mapper
public interface DhPassengerMapper extends BaseMapper<DhPassenger> {
    DhPassenger selectByChannelAndPassengerPhone(String channel, String passengerPhone);

    void upsert(DhPassenger dataFrom);
}
