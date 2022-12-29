package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-25  16:50
 */

@Data
@TableName("datahospice.du_basic_quality")
public class DuBasicQuality {

    @TableId(type = IdType.AUTO)
    private String id;


    private String ipcType;


    private String phoneNo;

    private String name;

    private String vehicleNo;

    private String certNo;

    private String data;

    private String channel;

    private String address;

    private Long storageTime;
}
