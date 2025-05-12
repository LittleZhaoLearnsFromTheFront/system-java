package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysFertilization;

/**
 * 施肥Service接口
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
public interface ISysFertilizationService 
{
    /**
     * 查询施肥
     * 
     * @param id 施肥主键
     * @return 施肥
     */
    public SysFertilization selectSysFertilizationById(Long id);

    /**
     * 查询施肥列表
     * 
     * @param sysFertilization 施肥
     * @return 施肥集合
     */
    public List<SysFertilization> selectSysFertilizationList(SysFertilization sysFertilization);

    /**
     * 新增施肥
     * 
     * @param sysFertilization 施肥
     * @return 结果
     */
    public int insertSysFertilization(SysFertilization sysFertilization);

    /**
     * 修改施肥
     * 
     * @param sysFertilization 施肥
     * @return 结果
     */
    public int updateSysFertilization(SysFertilization sysFertilization);

    /**
     * 批量删除施肥
     * 
     * @param ids 需要删除的施肥主键集合
     * @return 结果
     */
    public int deleteSysFertilizationByIds(Long[] ids);

    /**
     * 删除施肥信息
     * 
     * @param id 施肥主键
     * @return 结果
     */
    public int deleteSysFertilizationById(Long id);
}
