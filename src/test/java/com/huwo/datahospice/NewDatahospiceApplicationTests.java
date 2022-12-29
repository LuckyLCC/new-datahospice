package com.huwo.datahospice;

import com.huwo.datahospice.domain.DhDriver;
import com.huwo.datahospice.domain.DuBasicQuality;
import com.huwo.datahospice.mapper.BasicQualityServiceMapper;
import com.huwo.datahospice.mapper.DhDriverMapper;
import com.huwo.datahospice.service.BasicQualityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class NewDatahospiceApplicationTests {

    @Autowired
    private BasicQualityService basicQualityService;

    @Autowired
    private DhDriverMapper dhDriverMapper;

    @Autowired
    private BasicQualityServiceMapper basicQualityServiceMapper;

    @Test
    void contextLoads1() {

        DuBasicQuality duBasicQuality = basicQualityServiceMapper.selectById("1 ");

    }

    @Test
    void contextLoads2() {
        DhDriver dhDriver = new DhDriver();
        dhDriver.setId("2");
        dhDriver.setChannel("hw");
        dhDriver.setLicenseId("1234");
        dhDriver.setAddress(10000);
        dhDriverMapper.upsert(dhDriver);

    }

    @Test
    void contextLoads3() {
        String channel = "hw";
        String licenseId = "12345";
        Integer address = 55555;
        DhDriver dhDriver = dhDriverMapper.selectByChannelAndLicenseIdAndAddress(channel, licenseId, address);
        System.out.println(dhDriver);
    }

    @Test
    void contextLoads4() {
        DhDriver dhDriver1 = new DhDriver();
        dhDriver1.setAddress(100000);
        dhDriver1.setLicenseId("111111");
        dhDriver1.setChannel("HW");
        dhDriver1.setCertificateNo("wode");

        DhDriver dhDriver2 = new DhDriver();
        dhDriver2.setId("2");
        dhDriver2.setAddress(200000);
        dhDriver2.setLicenseId("22222");
        dhDriver2.setCertificateNo("wode222");

        BeanUtils.copyProperties(dhDriver1,dhDriver2);

        System.out.println(dhDriver2);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.of("+8"));
        Long aLong = Long.valueOf(localDateTime.format(dateTimeFormatter));
        System.out.println(aLong);
    }


}
