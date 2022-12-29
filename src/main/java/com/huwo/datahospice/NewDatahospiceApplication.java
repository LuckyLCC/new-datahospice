package com.huwo.datahospice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huwo.datahospice.mapper")
public class NewDatahospiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewDatahospiceApplication.class, args);
    }

}
