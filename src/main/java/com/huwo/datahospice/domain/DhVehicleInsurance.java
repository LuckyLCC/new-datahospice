package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.huwo.data.upstream.api.annotation.VehiclePlate;
import com.huwo.data.upstream.api.biz.DuVehicleInsurance;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author ZhangAihua
 * @date 2021/4/20 0020 14:51
 */
@Data
@TableName("datahospice.dh_vehicle_insurance")
public class DhVehicleInsurance {

    private String id;
    @NotBlank(
            message = "公司标识不能为空"
    )
    private String companyId;
    @NotBlank(
            message = "车辆号牌不能为空"
    )
    @VehiclePlate(
            message = "车辆号牌不正确"
    )
    private String vehicleNo;
    @NotBlank(
            message = "保险公司名称不能为空"
    )
    private String insurCom;
    @NotBlank(
            message = "保险号不能为空"
    )
    private String insurNum;
    private String insurType = "1";
    @NotNull(
            message = "保险金额不能为空"
    )
    private BigDecimal insurCount;
    @NotNull(
            message = "保险生效时间不能为空"
    )
    private Integer insurEff;
    @NotNull(
            message = "保险到期时间不能为空"
    )
    private Integer insurExp;
    @NotNull(
            message = "操作标识不能为空"
    )
    private Integer flag;
    @NotNull(
            message = "更新时间不能为空"
    )
    private Long updateTime;
    private String plateColor;
    private Integer address;
    private String symbol;

    /**
     * 渠道 MT-美团， LX-灵犀
     */
    private String channel;

    /**
     * 创建时间
     */
    private Long createTime;
}
