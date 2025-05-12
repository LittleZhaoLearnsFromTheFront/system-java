package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysFertilizationInventory;

/**
 * 肥料库存管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
public interface SysFertilizationInventoryMapper 
{
    /**
     * 查询肥料库存管理
     * 
     * @param id 肥料库存管理主键
     * @return 肥料库存管理
     */
    public SysFertilizationInventory selectSysFertilizationInventoryById(Long id);

    /**
     * 查询肥料库存管理列表
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 肥料库存管理集合
     */
    public List<SysFertilizationInventory> selectSysFertilizationInventoryList(SysFertilizationInventory sysFertilizationInventory);

    /**
     * 新增肥料库存管理
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 结果
     */
    public int insertSysFertilizationInventory(SysFertilizationInventory sysFertilizationInventory);

    /**
     * 修改肥料库存管理
     * 
     * @param sysFertilizationInventory 肥料库存管理
     * @return 结果
     */
    public int updateSysFertilizationInventory(SysFertilizationInventory sysFertilizationInventory);

    /**
     * 删除肥料库存管理
     * 
     * @param id 肥料库存管理主键
     * @return 结果
     */
    public int deleteSysFertilizationInventoryById(Long id);

    /**
     * 批量删除肥料库存管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFertilizationInventoryByIds(Long[] ids);
}
