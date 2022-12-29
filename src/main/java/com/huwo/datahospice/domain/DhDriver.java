package com.huwo.datahospice.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.huwo.data.upstream.api.annotation.IdCard;
import com.huwo.data.upstream.api.biz.DuDriver;
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
@TableName("datahospice.dh_driver")
public class DhDriver {

    private String id;
    @NotBlank(
            message = "公司标识不能为空"
    )
    private String companyId;
    @NotNull(
            message = "注册地行政区划代码不能为空"
    )
    private Integer address;
    @NotBlank(
            message = "驾驶员手机号不能为空"
    )
    private String driverPhone;
    private String driverGender = "1";
    @NotNull(
            message = "出生日期不能为空"
    )
    private Integer driverBirthday;
    private String driverNation = "汉族";
    private String driverContactAddress = "1";
    @NotBlank(
            message = "机动车驾驶证号不能为空"
    )
    @IdCard(
            message = "机动车驾驶证号不正确"
    )
    private String licenseId;
    private Integer getDriverLicenseDate = RTimeUtil.date2Long();
    private Integer driverLicenseOn = RTimeUtil.date2Long();
    private Integer driverLicenseOff = RTimeUtil.date2Long(LocalDateTime.now().plusYears(10L));
    private Integer taxiDriver = 0;
    private String certificateNo = "1";
    private String networkCarIssueOrganization = "1";
    private Integer networkCarIssueDate = RTimeUtil.date2Long();
    private Integer getNetworkCarProofDate = RTimeUtil.date2Long();
    private Integer networkCarProofOn = RTimeUtil.date2Long();
    private Integer networkCarProofOff = RTimeUtil.date2Long(LocalDateTime.now().plusYears(10L));
    private Integer registerDate = RTimeUtil.date2Long();
    private Integer commercialType = 1;
    private String contractCompany = "1";
    private Integer contractOn = RTimeUtil.date2Long();
    private Integer contractOff = RTimeUtil.date2Long(LocalDateTime.now().plusYears(3L));
    private Integer state = 0;
    @NotNull(
            message = "操作标识不能为空"
    )
    private Integer flag;
    @NotNull(
            message = "更新时间不能为空"
    )
    private Long updateTime;
    private String driverIDCard;
    private String rewardPunishment;
    private String driverName;
    private String symbol;
    private String emergencyContact;
    private String emergencyContactPhone;
    private String emergencyContactAddress;
    private Integer fullTimeDriver;
    private Integer inDriverBlacklist;


    /**
     * 渠道 MT-美团， LX-灵犀
     */
    private String channel;

    /**
     * 创建时间
     */
    private Long createTime;
}
