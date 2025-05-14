package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysVariety;

/**
 * 猕猴桃种类信息Service接口
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public interface ISysVarietyService 
{
    /**
     * 查询猕猴桃种类信息
     * 
     * @param varietyId 猕猴桃种类信息主键
     * @return 猕猴桃种类信息
     */
    public SysVariety selectSysVarietyByVarietyId(Long varietyId);

    /**
     * 查询猕猴桃种类信息列表
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 猕猴桃种类信息集合
     */
    public List<SysVariety> selectSysVarietyList(SysVariety sysVariety);

    /**
     * 新增猕猴桃种类信息
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 结果
     */
    public int insertSysVariety(SysVariety sysVariety);

    /**
     * 修改猕猴桃种类信息
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 结果
     */
    public int updateSysVariety(SysVariety sysVariety);

    /**
     * 批量删除猕猴桃种类信息
     * 
     * @param varietyIds 需要删除的猕猴桃种类信息主键集合
     * @return 结果
     */
    public int deleteSysVarietyByVarietyIds(Long[] varietyIds);

    /**
     * 删除猕猴桃种类信息信息
     * 
     * @param varietyId 猕猴桃种类信息主键
     * @return 结果
     */
    public int deleteSysVarietyByVarietyId(Long varietyId);
}
