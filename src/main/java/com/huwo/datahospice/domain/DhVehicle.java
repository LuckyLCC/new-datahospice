package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.huwo.data.upstream.api.annotation.VehiclePlate;
import com.huwo.data.upstream.api.biz.DuVehicle;
import com.huwo.data.upstream.api.util.RTimeUtil;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author ZhangAihua
 * @date 2021/4/20 0020 14:51
 */
@Data
@TableName("datahospice.dh_vehicle")
public class DhVehicle {

    private String id;
    @NotBlank(
            message = "公司标识不能为空"
    )
    private String companyId;
    @NotNull(
            message = "车辆所在城市不能为空"
    )
    private Integer address;
    @NotBlank(
            message = "车辆号牌不能为空"
    )
    @VehiclePlate(
            message = "车辆号牌不正确"
    )
    private String vehicleNo;
    private String plateColor = "1";
    private Integer seats = 4;
    private String brand = "1";
    private String model = "1";
    private String vehicleType = "小型普通客车";
    private String ownerName = "1";
    private String vehicleColor = "白色";
    private String engineId = "1";
    private String vin = "1";
    private Integer certifyDateA = RTimeUtil.date2Long();
    private String fuelType = "A";
    private String engineDisplace = "1400";
    private String transAgency = "1";
    private String transArea = "1";
    private Integer transDateStart = RTimeUtil.date2Long();
    private Integer transDateStop = RTimeUtil.date2Long(LocalDateTime.now().plusYears(10L));
    private Integer certifyDateB = RTimeUtil.date2Long();
    private String fixStateb = "1";
    private String checkState = "1";
    private String feePrintId = "1";
    private String gpsBrand = "1";
    private String gpsModel = "1";
    private String gpsImei = "1";
    private Integer gpsInstallDate = RTimeUtil.date2Long();
    private Integer registerDate = RTimeUtil.date2Long();
    private Integer commercialType = 1;
    private String fareType = "1";
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
    private String enginePower;
    private String wheelBase;
    private Integer checkDate;
    private String vehicleTec;
    private String vehicleSafe;
    private String symbol;
    private String certificate;
    private Integer nextFixDate;
    private String driverLicense;
    private Integer driverLicenseStartTime;
    private Integer driverLicenseEndTime;

    /**
     * 渠道 MT-美团， LX-灵犀
     */
    private String channel;

    /**
     * 创建时间
     */
    private Long createTime;
}
