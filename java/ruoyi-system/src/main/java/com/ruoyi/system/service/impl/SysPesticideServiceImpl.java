package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPesticideMapper;
import com.ruoyi.system.domain.SysPesticide;
import com.ruoyi.system.service.ISysPesticideService;

/**
 * 治理用药管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@Service
public class SysPesticideServiceImpl implements ISysPesticideService 
{
    @Autowired
    private SysPesticideMapper sysPesticideMapper;

    /**
     * 查询治理用药管理
     * 
     * @param id 治理用药管理主键
     * @return 治理用药管理
     */
    @Override
    public SysPesticide selectSysPesticideById(Long id)
    {
        return sysPesticideMapper.selectSysPesticideById(id);
    }

    /**
     * 查询治理用药管理列表
     * 
     * @param sysPesticide 治理用药管理
     * @return 治理用药管理
     */
    @Override
    public List<SysPesticide> selectSysPesticideList(SysPesticide sysPesticide)
    {
        return sysPesticideMapper.selectSysPesticideList(sysPesticide);
    }

    /**
     * 新增治理用药管理
     * 
     * @param sysPesticide 治理用药管理
     * @return 结果
     */
    @Override
    public int insertSysPesticide(SysPesticide sysPesticide)
    {
        sysPesticide.setCreateTime(DateUtils.getNowDate());
        return sysPesticideMapper.insertSysPesticide(sysPesticide);
    }

    /**
     * 修改治理用药管理
     * 
     * @param sysPesticide 治理用药管理
     * @return 结果
     */
    @Override
    public int updateSysPesticide(SysPesticide sysPesticide)
    {
        sysPesticide.setUpdateTime(DateUtils.getNowDate());
        return sysPesticideMapper.updateSysPesticide(sysPesticide);
    }

    /**
     * 批量删除治理用药管理
     * 
     * @param ids 需要删除的治理用药管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPesticideByIds(Long[] ids)
    {
        return sysPesticideMapper.deleteSysPesticideByIds(ids);
    }

    /**
     * 删除治理用药管理信息
     * 
     * @param id 治理用药管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPesticideById(Long id)
    {
        return sysPesticideMapper.deleteSysPesticideById(id);
    }
}
