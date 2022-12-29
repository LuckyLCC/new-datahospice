package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-26  11:15
 */

@Data
@TableName("liuchang.us_population")
public class UserPopulation {

    @TableId(type = IdType.AUTO)
    private String state;


    private String city;
    private String population;

}
