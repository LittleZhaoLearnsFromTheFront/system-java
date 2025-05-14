package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 猕猴桃种类信息对象 sys_variety
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public class SysVariety extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long varietyId;

    /** 品种名称 */
    @Excel(name = "品种名称")
    private String varietyName;

    /** 品种学名 */
    @Excel(name = "品种学名")
    private String scientificName;

    /** 品种类型 */
    @Excel(name = "品种类型")
    private String varietyType;



    /** 育成年份 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "育成年份", width = 30, dateFormat = "yyyy-MM-dd")
    private Date breedingYear;

    /** 果实形状 */
    @Excel(name = "果实形状")
    private String fruitShape;

    /** 果实大小 */
    @Excel(name = "果实大小")
    private String fruitSize;

    /** 平均单果重 */
    @Excel(name = "平均单果重")
    private BigDecimal averageWeight;

    /** 果面色泽 */
    @Excel(name = "果面色泽")
    private String skinColor;

    /** 抗病性 */
    @Excel(name = "抗病性")
    private String diseaseResistance;

    /** 抗虫性 */
    @Excel(name = "抗虫性")
    private String insectResistance;

    /** 生长势 */
    @Excel(name = "生长势")
    private String growthVigor;

    /** 病虫害防治措施 */
    @Excel(name = "病虫害防治措施")
    private String pestControlMeasures;

    /** 适宜产地id */
    @Excel(name = "适宜产地id")
    private Long originId;

    @Excel(name = "适宜产地名称")
    private String originName;

    public void setVarietyId(Long varietyId) 
    {
        this.varietyId = varietyId;
    }

    public Long getVarietyId() 
    {
        return varietyId;
    }

    public void setVarietyName(String varietyName) 
    {
        this.varietyName = varietyName;
    }

    public String getVarietyName() 
    {
        return varietyName;
    }

    public void setScientificName(String scientificName) 
    {
        this.scientificName = scientificName;
    }

    public String getScientificName() 
    {
        return scientificName;
    }

    public void setVarietyType(String varietyType) 
    {
        this.varietyType = varietyType;
    }

    public String getVarietyType() 
    {
        return varietyType;
    }


    public void setBreedingYear(Date breedingYear) 
    {
        this.breedingYear = breedingYear;
    }

    public Date getBreedingYear() 
    {
        return breedingYear;
    }

    public void setFruitShape(String fruitShape) 
    {
        this.fruitShape = fruitShape;
    }

    public String getFruitShape() 
    {
        return fruitShape;
    }

    public void setFruitSize(String fruitSize) 
    {
        this.fruitSize = fruitSize;
    }

    public String getFruitSize() 
    {
        return fruitSize;
    }

    public void setAverageWeight(BigDecimal averageWeight) 
    {
        this.averageWeight = averageWeight;
    }

    public BigDecimal getAverageWeight() 
    {
        return averageWeight;
    }

    public void setSkinColor(String skinColor) 
    {
        this.skinColor = skinColor;
    }

    public String getSkinColor() 
    {
        return skinColor;
    }

    public void setDiseaseResistance(String diseaseResistance) 
    {
        this.diseaseResistance = diseaseResistance;
    }

    public String getDiseaseResistance() 
    {
        return diseaseResistance;
    }

    public void setInsectResistance(String insectResistance) 
    {
        this.insectResistance = insectResistance;
    }

    public String getInsectResistance() 
    {
        return insectResistance;
    }

    public void setGrowthVigor(String growthVigor) 
    {
        this.growthVigor = growthVigor;
    }

    public String getGrowthVigor() 
    {
        return growthVigor;
    }

    public void setPestControlMeasures(String pestControlMeasures) 
    {
        this.pestControlMeasures = pestControlMeasures;
    }

    public String getPestControlMeasures() 
    {
        return pestControlMeasures;
    }

    public void setOriginId(Long originId) 
    {
        this.originId = originId;
    }

    public Long getOriginId() 
    {
        return originId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("varietyId", getVarietyId())
            .append("varietyName", getVarietyName())
            .append("scientificName", getScientificName())
            .append("varietyType", getVarietyType())
            .append("breedingYear", getBreedingYear())
            .append("fruitShape", getFruitShape())
            .append("fruitSize", getFruitSize())
            .append("averageWeight", getAverageWeight())
            .append("skinColor", getSkinColor())
            .append("diseaseResistance", getDiseaseResistance())
            .append("insectResistance", getInsectResistance())
            .append("growthVigor", getGrowthVigor())
            .append("pestControlMeasures", getPestControlMeasures())
            .append("originId", getOriginId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }
}
