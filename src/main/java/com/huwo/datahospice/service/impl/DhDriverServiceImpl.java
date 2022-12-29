package com.huwo.datahospice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.mapper.BasicQualityServiceMapper;
import com.huwo.datahospice.mapper.DhDriverMapper;
import com.huwo.datahospice.service.BasicQualityService;
import com.huwo.datahospice.service.DhDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-27  12:03
 */
@Service
public class DhDriverServiceImpl extends ServiceImpl<DhDriverMapper, DhDriver> implements DhDriverService {

    @Autowired
    private DhDriverMapper dhDriverMapper;


    @Override
    public int upsert(DhDriver dhDriver) {
        dhDriverMapper.upsert(dhDriver);
        return 0;
    }

    @Override
    public DhDriver selectByChannelAndLicenseIdAndAddress(String channel, String licenseId, Integer address) {
        return dhDriverMapper.selectByChannelAndLicenseIdAndAddress(channel,licenseId,address);
    }
}
