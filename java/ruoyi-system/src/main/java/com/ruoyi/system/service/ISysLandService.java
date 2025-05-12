package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysLand;

/**
 * 土地Service接口
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
public interface ISysLandService 
{
    /**
     * 查询土地
     * 
     * @param id 土地主键
     * @return 土地
     */
    public SysLand selectSysLandById(Long id);

    /**
     * 查询土地列表
     * 
     * @param sysLand 土地
     * @return 土地集合
     */
    public List<SysLand> selectSysLandList(SysLand sysLand);

    /**
     * 新增土地
     * 
     * @param sysLand 土地
     * @return 结果
     */
    public int insertSysLand(SysLand sysLand);

    /**
     * 修改土地
     * 
     * @param sysLand 土地
     * @return 结果
     */
    public int updateSysLand(SysLand sysLand);

    /**
     * 批量删除土地
     * 
     * @param ids 需要删除的土地主键集合
     * @return 结果
     */
    public int deleteSysLandByIds(Long[] ids);

    /**
     * 删除土地信息
     * 
     * @param id 土地主键
     * @return 结果
     */
    public int deleteSysLandById(Long id);
}
