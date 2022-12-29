package com.huwo.datahospice.mapper;

import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DhDriverMapper extends BaseMapper<DhDriver> {

    int upsert(DhDriver dhDriver);

    DhDriver selectByChannelAndLicenseIdAndAddress(String channel,String licenseId,Integer address);
}
