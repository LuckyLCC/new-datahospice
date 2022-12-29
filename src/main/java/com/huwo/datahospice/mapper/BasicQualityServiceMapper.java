package com.huwo.datahospice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huwo.datahospice.domain.DuBasicQuality;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Max;

@Mapper
public interface BasicQualityServiceMapper  extends BaseMapper<DuBasicQuality> {

    int upsert(DuBasicQuality duBasicQuality);
}
