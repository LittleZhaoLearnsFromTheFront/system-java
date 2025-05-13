package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 肥料库存管理对象 sys_fertilization_inventory
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
public class SysFertilizationInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 肥料名 */
    @Excel(name = "肥料名")
    private String title;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private Long remainingQuantity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setRemainingQuantity(Long remainingQuantity) 
    {
        this.remainingQuantity = remainingQuantity;
    }

    public Long getRemainingQuantity() 
    {
        return remainingQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("quantity", getQuantity())
            .append("unit", getUnit())
            .append("remainingQuantity", getRemainingQuantity())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
