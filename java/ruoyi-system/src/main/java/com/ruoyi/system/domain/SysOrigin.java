package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 猕猴桃产地信息对象 sys_origin
 * 
 * @author ruoyi
 * @date 2025-05-14
 */
public class SysOrigin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long originId;

    /** 产地名称 */
    @Excel(name = "产地名称")
    private String originName;

    /** 行政区划代码 */
    @Excel(name = "行政区划代码")
    private String regionCode;

    /** 气候带 */
    @Excel(name = "气候带")
    private String climateZone;

    /** 最高海拔 */
    @Excel(name = "最高海拔")
    private BigDecimal maxAltitude;

    /** 最低海拔 */
    @Excel(name = "最低海拔")
    private BigDecimal minAltitude;

    /** 海拔(米) */
    @Excel(name = "海拔(米)")
    private BigDecimal altitude;

    /** 坡度(度) */
    @Excel(name = "坡度(度)")
    private BigDecimal slope;

    /** 地形类型(1:平原,2:丘陵,3:山地,4:高原) */
    @Excel(name = "地形类型(1:平原,2:丘陵,3:山地,4:高原)")
    private Long terrainType;

    /** 种植面积(亩) */
    @Excel(name = "种植面积(亩)")
    private BigDecimal acreage;

    /** 主要种植品种 */
    @Excel(name = "主要种植品种")
    private String mainVarieties;

    /** 年最高气温(°C) */
    @Excel(name = "年最高气温(°C)")
    private BigDecimal maxTemperature;

    /** 年最低气温(°C) */
    @Excel(name = "年最低气温(°C)")
    private BigDecimal minTemperature;

    /** 年平均气温(°C) */
    @Excel(name = "年平均气温(°C)")
    private BigDecimal avgTemperature;

    /** 最小降水量 */
    @Excel(name = "最小降水量")
    private BigDecimal minPrecipitation;

    /** 最大降水量 */
    @Excel(name = "最大降水量")
    private BigDecimal maxPrecipitation;

    /** 年降水量(mm) */
    @Excel(name = "年降水量(mm)")
    private BigDecimal precipitation;

    public void setOriginId(Long originId) 
    {
        this.originId = originId;
    }

    public Long getOriginId() 
    {
        return originId;
    }

    public void setOriginName(String originName) 
    {
        this.originName = originName;
    }

    public String getOriginName() 
    {
        return originName;
    }

    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }

    public void setClimateZone(String climateZone) 
    {
        this.climateZone = climateZone;
    }

    public String getClimateZone() 
    {
        return climateZone;
    }

    public void setMaxAltitude(BigDecimal maxAltitude) 
    {
        this.maxAltitude = maxAltitude;
    }

    public BigDecimal getMaxAltitude() 
    {
        return maxAltitude;
    }

    public void setMinAltitude(BigDecimal minAltitude) 
    {
        this.minAltitude = minAltitude;
    }

    public BigDecimal getMinAltitude() 
    {
        return minAltitude;
    }

    public void setAltitude(BigDecimal altitude) 
    {
        this.altitude = altitude;
    }

    public BigDecimal getAltitude() 
    {
        return altitude;
    }

    public void setSlope(BigDecimal slope) 
    {
        this.slope = slope;
    }

    public BigDecimal getSlope() 
    {
        return slope;
    }

    public void setTerrainType(Long terrainType) 
    {
        this.terrainType = terrainType;
    }

    public Long getTerrainType() 
    {
        return terrainType;
    }

    public void setAcreage(BigDecimal acreage) 
    {
        this.acreage = acreage;
    }

    public BigDecimal getAcreage() 
    {
        return acreage;
    }

    public void setMainVarieties(String mainVarieties) 
    {
        this.mainVarieties = mainVarieties;
    }

    public String getMainVarieties() 
    {
        return mainVarieties;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) 
    {
        this.maxTemperature = maxTemperature;
    }

    public BigDecimal getMaxTemperature() 
    {
        return maxTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) 
    {
        this.minTemperature = minTemperature;
    }

    public BigDecimal getMinTemperature() 
    {
        return minTemperature;
    }

    public void setAvgTemperature(BigDecimal avgTemperature) 
    {
        this.avgTemperature = avgTemperature;
    }

    public BigDecimal getAvgTemperature() 
    {
        return avgTemperature;
    }

    public void setMinPrecipitation(BigDecimal minPrecipitation) 
    {
        this.minPrecipitation = minPrecipitation;
    }

    public BigDecimal getMinPrecipitation() 
    {
        return minPrecipitation;
    }

    public void setMaxPrecipitation(BigDecimal maxPrecipitation) 
    {
        this.maxPrecipitation = maxPrecipitation;
    }

    public BigDecimal getMaxPrecipitation() 
    {
        return maxPrecipitation;
    }

    public void setPrecipitation(BigDecimal precipitation) 
    {
        this.precipitation = precipitation;
    }

    public BigDecimal getPrecipitation() 
    {
        return precipitation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("originId", getOriginId())
            .append("originName", getOriginName())
            .append("regionCode", getRegionCode())
            .append("climateZone", getClimateZone())
            .append("maxAltitude", getMaxAltitude())
            .append("minAltitude", getMinAltitude())
            .append("altitude", getAltitude())
            .append("slope", getSlope())
            .append("terrainType", getTerrainType())
            .append("acreage", getAcreage())
            .append("mainVarieties", getMainVarieties())
            .append("maxTemperature", getMaxTemperature())
            .append("minTemperature", getMinTemperature())
            .append("avgTemperature", getAvgTemperature())
            .append("minPrecipitation", getMinPrecipitation())
            .append("maxPrecipitation", getMaxPrecipitation())
            .append("precipitation", getPrecipitation())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
