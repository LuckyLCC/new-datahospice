package com.huwo.datahospice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.mapper.BasicQualityServiceMapper;
import com.huwo.datahospice.service.BasicQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-25  15:09
 */
@Service
public class BasicQualityServiceImpl extends ServiceImpl<BasicQualityServiceMapper, DuBasicQuality> implements BasicQualityService {

    @Autowired
    private BasicQualityServiceMapper basicQualityServiceMapper;

    @Override
    public int upsert(DuBasicQuality duBasicQuality) {

        int upsert = basicQualityServiceMapper.upsert(duBasicQuality);
        return upsert;
    }
}
