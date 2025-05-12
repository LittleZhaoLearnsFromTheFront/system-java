package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 浇水管理对象 sys_watering
 * 
 * @author hanxiao.zhao
 * @date 2025-05-11
 */
public class SysWatering extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 土地id */
    @Excel(name = "土地id")
    private Long landId;
    @Excel(name = "土地名称")
    private String landName;

    /** 浇水时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "浇水时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 浇水人 */
    @Excel(name = "浇水人")
    private String owner;

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

    public void setLandName(String landName){this.landName = landName;}

    public String getLandName(){return landName;}

    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }

    public void setOwner(String owner) 
    {
        this.owner = owner;
    }

    public String getOwner() 
    {
        return owner;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("landId", getLandId())
                .append("landName", getLandName())
            .append("time", getTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("owner", getOwner())
            .toString();
    }
}
