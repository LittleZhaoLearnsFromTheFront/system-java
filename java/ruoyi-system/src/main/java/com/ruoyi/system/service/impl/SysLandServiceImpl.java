package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysLandMapper;
import com.ruoyi.system.domain.SysLand;
import com.ruoyi.system.service.ISysLandService;

/**
 * 土地Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@Service
public class SysLandServiceImpl implements ISysLandService 
{
    @Autowired
    private SysLandMapper sysLandMapper;

    /**
     * 查询土地
     * 
     * @param id 土地主键
     * @return 土地
     */
    @Override
    public SysLand selectSysLandById(Long id)
    {
        return sysLandMapper.selectSysLandById(id);
    }

    /**
     * 查询土地列表
     * 
     * @param sysLand 土地
     * @return 土地
     */
    @Override
    public List<SysLand> selectSysLandList(SysLand sysLand)
    {
        return sysLandMapper.selectSysLandList(sysLand);
    }

    /**
     * 新增土地
     * 
     * @param sysLand 土地
     * @return 结果
     */
    @Override
    public int insertSysLand(SysLand sysLand)
    {
        sysLand.setCreateTime(DateUtils.getNowDate());
        return sysLandMapper.insertSysLand(sysLand);
    }

    /**
     * 修改土地
     * 
     * @param sysLand 土地
     * @return 结果
     */
    @Override
    public int updateSysLand(SysLand sysLand)
    {
        sysLand.setUpdateTime(DateUtils.getNowDate());
        return sysLandMapper.updateSysLand(sysLand);
    }

    /**
     * 批量删除土地
     * 
     * @param ids 需要删除的土地主键
     * @return 结果
     */
    @Override
    public int deleteSysLandByIds(Long[] ids)
    {
        return sysLandMapper.deleteSysLandByIds(ids);
    }

    /**
     * 删除土地信息
     * 
     * @param id 土地主键
     * @return 结果
     */
    @Override
    public int deleteSysLandById(Long id)
    {
        return sysLandMapper.deleteSysLandById(id);
    }
}
