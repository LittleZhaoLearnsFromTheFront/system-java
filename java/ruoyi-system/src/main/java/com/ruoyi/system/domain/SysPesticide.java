package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 治理用药管理对象 sys_pesticide
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public class SysPesticide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 土地Id */
    @Excel(name = "土地Id")
    private Long landId;

    @Excel(name = "土地名称")
    private String landName;


    @Excel(name = "库存Id")
    private Long pesticideInventoryId;

    @Excel(name="库存名称")
    private String pesticideInventoryName;

    @Excel(name="单位")
    private  String unit;

    /** 用药人 */
    @Excel(name = "用药人")
    private String owner;

    /** 用药时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "用药时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 用量 */
    @Excel(name = "用量")
    private Long dosage;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setLandId(Long landId)
    {
        this.landId = landId;
    }

    public Long getLandId()
    {
        return landId;
    }

    public void setLandName(String landName)
    {
        this.landName = landName;
    }

    public String getLandName()
    {
        return landName;
    }

    public void setPesticideInventoryId(Long pesticideInventoryId)
    {
        this.pesticideInventoryId = pesticideInventoryId;
    }

    public Long getPesticideInventoryId()
    {
        return pesticideInventoryId;
    }

    public  void setFertilizationInventoryName(String fertilizationInventoryName)
    {
        this.pesticideInventoryName = fertilizationInventoryName;
    }

    public  String getPesticideInventoryName()
    {
        return pesticideInventoryName;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public  String getUnit()
    {
        return unit;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwner() 
    {
        return owner;
    }

    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }

    public void setDosage(Long dosage) 
    {
        this.dosage = dosage;
    }

    public Long getDosage() 
    {
        return dosage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("owner", getOwner())
            .append("time", getTime())
            .append("dosage", getDosage())
            .append("remark", getRemark())
            .append("pesticideInventoryId", getPesticideInventoryId())
                .append("pesticideInventoryName", getPesticideInventoryName())
                .append("landName", getLandName())
                .append("landId", getLandId())
                .append("unit", getUnit())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
