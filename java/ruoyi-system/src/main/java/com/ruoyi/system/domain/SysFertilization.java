package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 施肥对象 sys_fertilization
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
public class SysFertilization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 土地id */
    @Excel(name = "土地id")
    private Long landId;

    @Excel(name = "土地名称")
    private String landName;

    /** 施肥人 */
    @Excel(name = "施肥人")
    private String owner;

    /** 施肥时间 */
    @Excel(name = "施肥时间")
    private String time;

    /** 用量 */
    @Excel(name = "用量")
    private String dosage;

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

    public void setOwner(String owner) 
    {
        this.owner = owner;
    }

    public String getOwner() 
    {
        return owner;
    }

    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
    {
        return time;
    }

    public void setDosage(String dosage) 
    {
        this.dosage = dosage;
    }

    public String getDosage() 
    {
        return dosage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("landId", getLandId())
                .append("landName", getLandName())
            .append("owner", getOwner())
            .append("time", getTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("dosage", getDosage())
            .append("remark", getRemark())
            .toString();
    }
}
