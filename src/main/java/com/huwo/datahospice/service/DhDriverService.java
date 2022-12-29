package com.huwo.datahospice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;

public interface DhDriverService extends IService<DhDriver> {

    int upsert(DhDriver dhDriver);

    DhDriver selectByChannelAndLicenseIdAndAddress(String channel,String licenseId,Integer address);
}
