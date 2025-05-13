package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFertilizationInventoryMapper;
import com.ruoyi.system.domain.SysFertilizationInventory;
import com.ruoyi.system.service.ISysFertilizationInventoryService;

/**
 * 肥料库存管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@Service
public class SysFertilizationInventoryServiceImpl implements ISysFertilizationInventoryService 
{
    @Autowired
    private SysFertilizationInventoryMapper sysFertilizationInventoryMapper;

    /**
     * 查询肥料库存管理
     * 
     * @param id 肥料库存管理主键
     * @return 肥料库存管理
     */
    @Override
    public SysFertilizationInventory selectSysFertilizationInventoryById(Long id)
    {
        return sysFertilizationInventoryMapper.selectSysFertilizationInventoryById(id);
    }

    /**
     * 查询肥料库存管理列表
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 肥料库存管理
     */
    @Override
    public List<SysFertilizationInventory> selectSysFertilizationInventoryList(SysFertilizationInventory sysFertilizationInventory)
    {
        return sysFertilizationInventoryMapper.selectSysFertilizationInventoryList(sysFertilizationInventory);
    }

    /**
     * 新增肥料库存管理
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 结果
     */
    @Override
    public int insertSysFertilizationInventory(SysFertilizationInventory sysFertilizationInventory)
    {
        sysFertilizationInventory.setCreateTime(DateUtils.getNowDate());
        return sysFertilizationInventoryMapper.insertSysFertilizationInventory(sysFertilizationInventory);
    }

    /**
     * 修改肥料库存管理
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 结果
     */
    @Override
    public int updateSysFertilizationInventory(SysFertilizationInventory sysFertilizationInventory)
    {
        sysFertilizationInventory.setUpdateTime(DateUtils.getNowDate());
        return sysFertilizationInventoryMapper.updateSysFertilizationInventory(sysFertilizationInventory);
    }

    /**
     * 批量删除肥料库存管理
     * 
     * @param ids 需要删除的肥料库存管理主键
     * @return 结果
     */
    @Override
    public int deleteSysFertilizationInventoryByIds(Long[] ids)
    {
        return sysFertilizationInventoryMapper.deleteSysFertilizationInventoryByIds(ids);
    }

    /**
     * 删除肥料库存管理信息
     * 
     * @param id 肥料库存管理主键
     * @return 结果
     */
    @Override
    public int deleteSysFertilizationInventoryById(Long id)
    {
        return sysFertilizationInventoryMapper.deleteSysFertilizationInventoryById(id);
    }
}
