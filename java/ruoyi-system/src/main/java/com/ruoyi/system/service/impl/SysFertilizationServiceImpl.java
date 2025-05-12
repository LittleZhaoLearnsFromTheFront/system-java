package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFertilizationMapper;
import com.ruoyi.system.domain.SysFertilization;
import com.ruoyi.system.service.ISysFertilizationService;

/**
 * 施肥Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@Service
public class SysFertilizationServiceImpl implements ISysFertilizationService 
{
    @Autowired
    private SysFertilizationMapper sysFertilizationMapper;

    /**
     * 查询施肥
     * 
     * @param id 施肥主键
     * @return 施肥
     */
    @Override
    public SysFertilization selectSysFertilizationById(Long id)
    {
        return sysFertilizationMapper.selectSysFertilizationById(id);
    }

    /**
     * 查询施肥列表
     * 
     * @param sysFertilization 施肥
     * @return 施肥
     */
    @Override
    public List<SysFertilization> selectSysFertilizationList(SysFertilization sysFertilization)
    {
        return sysFertilizationMapper.selectSysFertilizationList(sysFertilization);
    }

    /**
     * 新增施肥
     * 
     * @param sysFertilization 施肥
     * @return 结果
     */
    @Override
    public int insertSysFertilization(SysFertilization sysFertilization)
    {
        sysFertilization.setCreateTime(DateUtils.getNowDate());
        return sysFertilizationMapper.insertSysFertilization(sysFertilization);
    }

    /**
     * 修改施肥
     * 
     * @param sysFertilization 施肥
     * @return 结果
     */
    @Override
    public int updateSysFertilization(SysFertilization sysFertilization)
    {
        sysFertilization.setUpdateTime(DateUtils.getNowDate());
        return sysFertilizationMapper.updateSysFertilization(sysFertilization);
    }

    /**
     * 批量删除施肥
     * 
     * @param ids 需要删除的施肥主键
     * @return 结果
     */
    @Override
    public int deleteSysFertilizationByIds(Long[] ids)
    {
        return sysFertilizationMapper.deleteSysFertilizationByIds(ids);
    }

    /**
     * 删除施肥信息
     * 
     * @param id 施肥主键
     * @return 结果
     */
    @Override
    public int deleteSysFertilizationById(Long id)
    {
        return sysFertilizationMapper.deleteSysFertilizationById(id);
    }
}
