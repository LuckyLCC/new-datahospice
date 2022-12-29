package com.huwo.datahospice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwo.datahospice.domain.DuBasicQuality;

public interface BasicQualityService extends IService<DuBasicQuality> {

    int upsert(DuBasicQuality duBasicQuality);
}
