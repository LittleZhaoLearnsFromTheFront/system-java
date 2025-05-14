package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPesticideInventory;

/**
 * pesticideInventoryMapper接口
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public interface SysPesticideInventoryMapper 
{
    /**
     * 查询pesticideInventory
     * 
     * @param id pesticideInventory主键
     * @return pesticideInventory
     */
    public SysPesticideInventory selectSysPesticideInventoryById(Long id);

    /**
     * 查询pesticideInventory列表
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return pesticideInventory集合
     */
    public List<SysPesticideInventory> selectSysPesticideInventoryList(SysPesticideInventory sysPesticideInventory);

    /**
     * 新增pesticideInventory
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return 结果
     */
    public int insertSysPesticideInventory(SysPesticideInventory sysPesticideInventory);

    /**
     * 修改pesticideInventory
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return 结果
     */
    public int updateSysPesticideInventory(SysPesticideInventory sysPesticideInventory);

    /**
     * 删除pesticideInventory
     * 
     * @param id pesticideInventory主键
     * @return 结果
     */
    public int deleteSysPesticideInventoryById(Long id);

    /**
     * 批量删除pesticideInventory
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPesticideInventoryByIds(Long[] ids);
}
