package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPruning;

/**
 * 整形修剪管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
public interface SysPruningMapper 
{
    /**
     * 查询整形修剪管理
     * 
     * @param id 整形修剪管理主键
     * @return 整形修剪管理
     */
    public SysPruning selectSysPruningById(Long id);

    /**
     * 查询整形修剪管理列表
     * 
     * @param sysPruning 整形修剪管理
     * @return 整形修剪管理集合
     */
    public List<SysPruning> selectSysPruningList(SysPruning sysPruning);

    /**
     * 新增整形修剪管理
     * 
     * @param sysPruning 整形修剪管理
     * @return 结果
     */
    public int insertSysPruning(SysPruning sysPruning);

    /**
     * 修改整形修剪管理
     * 
     * @param sysPruning 整形修剪管理
     * @return 结果
     */
    public int updateSysPruning(SysPruning sysPruning);

    /**
     * 删除整形修剪管理
     * 
     * @param id 整形修剪管理主键
     * @return 结果
     */
    public int deleteSysPruningById(Long id);

    /**
     * 批量删除整形修剪管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPruningByIds(Long[] ids);
}
