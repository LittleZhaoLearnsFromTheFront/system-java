package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPesticideInventoryMapper;
import com.ruoyi.system.domain.SysPesticideInventory;
import com.ruoyi.system.service.ISysPesticideInventoryService;

/**
 * pesticideInventoryService业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@Service
public class SysPesticideInventoryServiceImpl implements ISysPesticideInventoryService 
{
    @Autowired
    private SysPesticideInventoryMapper sysPesticideInventoryMapper;

    /**
     * 查询pesticideInventory
     * 
     * @param id pesticideInventory主键
     * @return pesticideInventory
     */
    @Override
    public SysPesticideInventory selectSysPesticideInventoryById(Long id)
    {
        return sysPesticideInventoryMapper.selectSysPesticideInventoryById(id);
    }

    /**
     * 查询pesticideInventory列表
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return pesticideInventory
     */
    @Override
    public List<SysPesticideInventory> selectSysPesticideInventoryList(SysPesticideInventory sysPesticideInventory)
    {
        return sysPesticideInventoryMapper.selectSysPesticideInventoryList(sysPesticideInventory);
    }

    /**
     * 新增pesticideInventory
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return 结果
     */
    @Override
    public int insertSysPesticideInventory(SysPesticideInventory sysPesticideInventory)
    {
        sysPesticideInventory.setCreateTime(DateUtils.getNowDate());
        return sysPesticideInventoryMapper.insertSysPesticideInventory(sysPesticideInventory);
    }

    /**
     * 修改pesticideInventory
     * 
     * @param sysPesticideInventory pesticideInventory
     * @return 结果
     */
    @Override
    public int updateSysPesticideInventory(SysPesticideInventory sysPesticideInventory)
    {
        sysPesticideInventory.setUpdateTime(DateUtils.getNowDate());
        return sysPesticideInventoryMapper.updateSysPesticideInventory(sysPesticideInventory);
    }

    /**
     * 批量删除pesticideInventory
     * 
     * @param ids 需要删除的pesticideInventory主键
     * @return 结果
     */
    @Override
    public int deleteSysPesticideInventoryByIds(Long[] ids)
    {
        return sysPesticideInventoryMapper.deleteSysPesticideInventoryByIds(ids);
    }

    /**
     * 删除pesticideInventory信息
     * 
     * @param id pesticideInventory主键
     * @return 结果
     */
    @Override
    public int deleteSysPesticideInventoryById(Long id)
    {
        return sysPesticideInventoryMapper.deleteSysPesticideInventoryById(id);
    }
}
