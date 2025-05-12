package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPestInfoMapper;
import com.ruoyi.system.domain.SysPestInfo;
import com.ruoyi.system.service.ISysPestInfoService;

/**
 * 病虫害信息查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@Service
public class SysPestInfoServiceImpl implements ISysPestInfoService 
{
    @Autowired
    private SysPestInfoMapper sysPestInfoMapper;

    /**
     * 查询病虫害信息查询
     * 
     * @param id 病虫害信息查询主键
     * @return 病虫害信息查询
     */
    @Override
    public SysPestInfo selectSysPestInfoById(Long id)
    {
        return sysPestInfoMapper.selectSysPestInfoById(id);
    }

    /**
     * 查询病虫害信息查询列表
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 病虫害信息查询
     */
    @Override
    public List<SysPestInfo> selectSysPestInfoList(SysPestInfo sysPestInfo)
    {
        return sysPestInfoMapper.selectSysPestInfoList(sysPestInfo);
    }

    /**
     * 新增病虫害信息查询
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 结果
     */
    @Override
    public int insertSysPestInfo(SysPestInfo sysPestInfo)
    {
        sysPestInfo.setCreateTime(DateUtils.getNowDate());
        return sysPestInfoMapper.insertSysPestInfo(sysPestInfo);
    }

    /**
     * 修改病虫害信息查询
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 结果
     */
    @Override
    public int updateSysPestInfo(SysPestInfo sysPestInfo)
    {
        sysPestInfo.setUpdateTime(DateUtils.getNowDate());
        return sysPestInfoMapper.updateSysPestInfo(sysPestInfo);
    }

    /**
     * 批量删除病虫害信息查询
     * 
     * @param ids 需要删除的病虫害信息查询主键
     * @return 结果
     */
    @Override
    public int deleteSysPestInfoByIds(Long[] ids)
    {
        return sysPestInfoMapper.deleteSysPestInfoByIds(ids);
    }

    /**
     * 删除病虫害信息查询信息
     * 
     * @param id 病虫害信息查询主键
     * @return 结果
     */
    @Override
    public int deleteSysPestInfoById(Long id)
    {
        return sysPestInfoMapper.deleteSysPestInfoById(id);
    }
}
