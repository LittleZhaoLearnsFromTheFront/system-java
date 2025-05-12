package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysWateringMapper;
import com.ruoyi.system.domain.SysWatering;
import com.ruoyi.system.service.ISysWateringService;

/**
 * 浇水管理Service业务层处理
 * 
 * @author hanxiao.zhao
 * @date 2025-05-11
 */
@Service
public class SysWateringServiceImpl implements ISysWateringService 
{
    @Autowired
    private SysWateringMapper sysWateringMapper;

    /**
     * 查询浇水管理
     * 
     * @param id 浇水管理主键
     * @return 浇水管理
     */
    @Override
    public SysWatering selectSysWateringById(Long id)
    {
        return sysWateringMapper.selectSysWateringById(id);
    }

    /**
     * 查询浇水管理列表
     * 
     * @param sysWatering 浇水管理
     * @return 浇水管理
     */
    @Override
    public List<SysWatering> selectSysWateringList(SysWatering sysWatering)
    {
        List<SysWatering> list = sysWateringMapper.selectSysWateringList(sysWatering);

        return list;
    }

    /**
     * 新增浇水管理
     * 
     * @param sysWatering 浇水管理
     * @return 结果
     */
    @Override
    public int insertSysWatering(SysWatering sysWatering)
    {
        sysWatering.setCreateTime(DateUtils.getNowDate());
        return sysWateringMapper.insertSysWatering(sysWatering);
    }

    /**
     * 修改浇水管理
     * 
     * @param sysWatering 浇水管理
     * @return 结果
     */
    @Override
    public int updateSysWatering(SysWatering sysWatering)
    {
        sysWatering.setUpdateTime(DateUtils.getNowDate());
        return sysWateringMapper.updateSysWatering(sysWatering);
    }

    /**
     * 批量删除浇水管理
     * 
     * @param ids 需要删除的浇水管理主键
     * @return 结果
     */
    @Override
    public int deleteSysWateringByIds(Long[] ids)
    {
        return sysWateringMapper.deleteSysWateringByIds(ids);
    }

    /**
     * 删除浇水管理信息
     * 
     * @param id 浇水管理主键
     * @return 结果
     */
    @Override
    public int deleteSysWateringById(Long id)
    {
        return sysWateringMapper.deleteSysWateringById(id);
    }
}
