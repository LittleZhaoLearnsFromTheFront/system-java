package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPruningMapper;
import com.ruoyi.system.domain.SysPruning;
import com.ruoyi.system.service.ISysPruningService;

/**
 * 整形修剪管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@Service
public class SysPruningServiceImpl implements ISysPruningService 
{
    @Autowired
    private SysPruningMapper sysPruningMapper;

    /**
     * 查询整形修剪管理
     * 
     * @param id 整形修剪管理主键
     * @return 整形修剪管理
     */
    @Override
    public SysPruning selectSysPruningById(Long id)
    {
        return sysPruningMapper.selectSysPruningById(id);
    }

    /**
     * 查询整形修剪管理列表
     * 
     * @param sysPruning 整形修剪管理
     * @return 整形修剪管理
     */
    @Override
    public List<SysPruning> selectSysPruningList(SysPruning sysPruning)
    {
        return sysPruningMapper.selectSysPruningList(sysPruning);
    }

    /**
     * 新增整形修剪管理
     * 
     * @param sysPruning 整形修剪管理
     * @return 结果
     */
    @Override
    public int insertSysPruning(SysPruning sysPruning)
    {
        sysPruning.setCreateTime(DateUtils.getNowDate());
        return sysPruningMapper.insertSysPruning(sysPruning);
    }

    /**
     * 修改整形修剪管理
     * 
     * @param sysPruning 整形修剪管理
     * @return 结果
     */
    @Override
    public int updateSysPruning(SysPruning sysPruning)
    {
        sysPruning.setUpdateTime(DateUtils.getNowDate());
        return sysPruningMapper.updateSysPruning(sysPruning);
    }

    /**
     * 批量删除整形修剪管理
     * 
     * @param ids 需要删除的整形修剪管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPruningByIds(Long[] ids)
    {
        return sysPruningMapper.deleteSysPruningByIds(ids);
    }

    /**
     * 删除整形修剪管理信息
     * 
     * @param id 整形修剪管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPruningById(Long id)
    {
        return sysPruningMapper.deleteSysPruningById(id);
    }
}
