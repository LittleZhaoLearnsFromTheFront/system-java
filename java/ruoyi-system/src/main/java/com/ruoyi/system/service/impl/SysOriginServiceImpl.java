package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysOriginMapper;
import com.ruoyi.system.domain.SysOrigin;
import com.ruoyi.system.service.ISysOriginService;

/**
 * 猕猴桃产地信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-14
 */
@Service
public class SysOriginServiceImpl implements ISysOriginService 
{
    @Autowired
    private SysOriginMapper sysOriginMapper;

    /**
     * 查询猕猴桃产地信息
     * 
     * @param originId 猕猴桃产地信息主键
     * @return 猕猴桃产地信息
     */
    @Override
    public SysOrigin selectSysOriginByOriginId(Long originId)
    {
        return sysOriginMapper.selectSysOriginByOriginId(originId);
    }

    /**
     * 查询猕猴桃产地信息列表
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 猕猴桃产地信息
     */
    @Override
    public List<SysOrigin> selectSysOriginList(SysOrigin sysOrigin)
    {
        return sysOriginMapper.selectSysOriginList(sysOrigin);
    }

    /**
     * 新增猕猴桃产地信息
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 结果
     */
    @Override
    public int insertSysOrigin(SysOrigin sysOrigin)
    {
        sysOrigin.setCreateTime(DateUtils.getNowDate());
        return sysOriginMapper.insertSysOrigin(sysOrigin);
    }

    /**
     * 修改猕猴桃产地信息
     * 
     * @param sysOrigin 猕猴桃产地信息
     * @return 结果
     */
    @Override
    public int updateSysOrigin(SysOrigin sysOrigin)
    {
        sysOrigin.setUpdateTime(DateUtils.getNowDate());
        return sysOriginMapper.updateSysOrigin(sysOrigin);
    }

    /**
     * 批量删除猕猴桃产地信息
     * 
     * @param originIds 需要删除的猕猴桃产地信息主键
     * @return 结果
     */
    @Override
    public int deleteSysOriginByOriginIds(Long[] originIds)
    {
        return sysOriginMapper.deleteSysOriginByOriginIds(originIds);
    }

    /**
     * 删除猕猴桃产地信息信息
     * 
     * @param originId 猕猴桃产地信息主键
     * @return 结果
     */
    @Override
    public int deleteSysOriginByOriginId(Long originId)
    {
        return sysOriginMapper.deleteSysOriginByOriginId(originId);
    }
}
