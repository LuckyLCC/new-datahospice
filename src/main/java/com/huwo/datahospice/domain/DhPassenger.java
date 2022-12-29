package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.huwo.data.upstream.api.biz.DuPassenger;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ZhangAihua
 * @date 2021/4/20 0020 14:51
 */
@Data
@TableName("datahospice.dh_passenger")
public class DhPassenger {

    private String id;
    @NotBlank(
            message = "公司标识不能为空"
    )
    private String companyId;
    @NotBlank(
            message = "乘客手机号不能为空"
    )
    private String passengerPhone;
    private String passengerName = "1";
    @NotBlank(
            message = "乘客性别不能为空"
    )
    private String passengerGender;
    @NotNull(
            message = "状态不能为空"
    )
    private Integer state;
    @NotNull(
            message = "操作标识不能为空"
    )
    private Integer flag;
    @NotNull(
            message = "更新时间不能为空"
    )
    private Long updateTime;
    private Integer address;
    private String symbol;
    private Integer registerDate;
    private Integer area;


    /**
     * 渠道 MT-美团， LX-灵犀
     */
    private String channel;

    /**
     * 创建时间
     */
    private Long createTime;
}
