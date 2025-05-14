package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysOrigin;

/**
 * 猕猴桃产地信息Service接口
 * 
 * @author ruoyi
 * @date 2025-05-14
 */
public interface ISysOriginService 
{
    /**
     * 查询猕猴桃产地信息
     * 
     * @param originId 猕猴桃产地信息主键
     * @return 猕猴桃产地信息
     */
    public SysOrigin selectSysOriginByOriginId(Long originId);

    /**
     * 查询猕猴桃产地信息列表
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 猕猴桃产地信息集合
     */
    public List<SysOrigin> selectSysOriginList(SysOrigin sysOrigin);

    /**
     * 新增猕猴桃产地信息
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 结果
     */
    public int insertSysOrigin(SysOrigin sysOrigin);

    /**
     * 修改猕猴桃产地信息
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 结果
     */
    public int updateSysOrigin(SysOrigin sysOrigin);

    /**
     * 批量删除猕猴桃产地信息
     * 
     * @param originIds 需要删除的猕猴桃产地信息主键集合
     * @return 结果
     */
    public int deleteSysOriginByOriginIds(Long[] originIds);

    /**
     * 删除猕猴桃产地信息信息
     * 
     * @param originId 猕猴桃产地信息主键
     * @return 结果
     */
    public int deleteSysOriginByOriginId(Long originId);
}
