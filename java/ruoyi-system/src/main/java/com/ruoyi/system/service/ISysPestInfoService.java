package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPestInfo;

/**
 * 病虫害信息查询Service接口
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
public interface ISysPestInfoService 
{
    /**
     * 查询病虫害信息查询
     * 
     * @param id 病虫害信息查询主键
     * @return 病虫害信息查询
     */
    public SysPestInfo selectSysPestInfoById(Long id);

    /**
     * 查询病虫害信息查询列表
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 病虫害信息查询集合
     */
    public List<SysPestInfo> selectSysPestInfoList(SysPestInfo sysPestInfo);

    /**
     * 新增病虫害信息查询
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 结果
     */
    public int insertSysPestInfo(SysPestInfo sysPestInfo);

    /**
     * 修改病虫害信息查询
     * 
     * @param sysPestInfo 病虫害信息查询
     * @return 结果
     */
    public int updateSysPestInfo(SysPestInfo sysPestInfo);

    /**
     * 批量删除病虫害信息查询
     * 
     * @param ids 需要删除的病虫害信息查询主键集合
     * @return 结果
     */
    public int deleteSysPestInfoByIds(Long[] ids);

    /**
     * 删除病虫害信息查询信息
     * 
     * @param id 病虫害信息查询主键
     * @return 结果
     */
    public int deleteSysPestInfoById(Long id);
}
