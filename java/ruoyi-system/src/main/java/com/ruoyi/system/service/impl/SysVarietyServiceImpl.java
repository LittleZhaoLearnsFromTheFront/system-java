package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysVarietyMapper;
import com.ruoyi.system.domain.SysVariety;
import com.ruoyi.system.service.ISysVarietyService;

/**
 * 猕猴桃种类信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@Service
public class SysVarietyServiceImpl implements ISysVarietyService 
{
    @Autowired
    private SysVarietyMapper sysVarietyMapper;

    /**
     * 查询猕猴桃种类信息
     * 
     * @param varietyId 猕猴桃种类信息主键
     * @return 猕猴桃种类信息
     */
    @Override
    public SysVariety selectSysVarietyByVarietyId(Long varietyId)
    {
        return sysVarietyMapper.selectSysVarietyByVarietyId(varietyId);
    }

    /**
     * 查询猕猴桃种类信息列表
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 猕猴桃种类信息
     */
    @Override
    public List<SysVariety> selectSysVarietyList(SysVariety sysVariety)
    {
        return sysVarietyMapper.selectSysVarietyList(sysVariety);
    }

    /**
     * 新增猕猴桃种类信息
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 结果
     */
    @Override
    public int insertSysVariety(SysVariety sysVariety)
    {
        sysVariety.setCreateTime(DateUtils.getNowDate());
        return sysVarietyMapper.insertSysVariety(sysVariety);
    }

    /**
     * 修改猕猴桃种类信息
     * 
     * @param sysVariety 猕猴桃种类信息
     * @return 结果
     */
    @Override
    public int updateSysVariety(SysVariety sysVariety)
    {
        sysVariety.setUpdateTime(DateUtils.getNowDate());
        return sysVarietyMapper.updateSysVariety(sysVariety);
    }

    /**
     * 批量删除猕猴桃种类信息
     * 
     * @param varietyIds 需要删除的猕猴桃种类信息主键
     * @return 结果
     */
    @Override
    public int deleteSysVarietyByVarietyIds(Long[] varietyIds)
    {
        return sysVarietyMapper.deleteSysVarietyByVarietyIds(varietyIds);
    }

    /**
     * 删除猕猴桃种类信息信息
     * 
     * @param varietyId 猕猴桃种类信息主键
     * @return 结果
     */
    @Override
    public int deleteSysVarietyByVarietyId(Long varietyId)
    {
        return sysVarietyMapper.deleteSysVarietyByVarietyId(varietyId);
    }
}
