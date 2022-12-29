package com.huwo.datahospice.controller;

import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.mapper.BasicQualityServiceMapper;
import com.huwo.datahospice.mapper.DhDriverMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-17  14:44
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private BasicQualityServiceMapper basicQualityServiceMapper;

    @Autowired
    private DhDriverMapper dhDriverMapper;

    @GetMapping("/kafka/test")
    public void sendMessage(String id,String ipctype) {
        DuBasicQuality duBasicQuality = new DuBasicQuality();
        duBasicQuality.setId(id);
        duBasicQuality.setIpcType(ipctype);
        basicQualityServiceMapper.upsert(duBasicQuality);


        System.out.println("success");
    }

    @GetMapping("/save")
    public void save(String id,String channel,Integer address,String licenseId) {
        DhDriver dhDriver = new DhDriver();
        dhDriver.setId(id);
        dhDriver.setChannel(channel);
        dhDriver.setLicenseId(licenseId);
        dhDriver.setAddress(address);
        dhDriverMapper.upsert(dhDriver);

        System.out.println("success");
    }


}
