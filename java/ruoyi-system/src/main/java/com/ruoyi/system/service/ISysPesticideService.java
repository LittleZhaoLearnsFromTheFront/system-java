package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPesticide;

/**
 * 治理用药管理Service接口
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public interface ISysPesticideService 
{
    /**
     * 查询治理用药管理
     * 
     * @param id 治理用药管理主键
     * @return 治理用药管理
     */
    public SysPesticide selectSysPesticideById(Long id);

    /**
     * 查询治理用药管理列表
     * 
     * @param sysPesticide 治理用药管理
     * @return 治理用药管理集合
     */
    public List<SysPesticide> selectSysPesticideList(SysPesticide sysPesticide);

    /**
     * 新增治理用药管理
     * 
     * @param sysPesticide 治理用药管理
     * @return 结果
     */
    public int insertSysPesticide(SysPesticide sysPesticide);

    /**
     * 修改治理用药管理
     * 
     * @param sysPesticide 治理用药管理
     * @return 结果
     */
    public int updateSysPesticide(SysPesticide sysPesticide);

    /**
     * 批量删除治理用药管理
     * 
     * @param ids 需要删除的治理用药管理主键集合
     * @return 结果
     */
    public int deleteSysPesticideByIds(Long[] ids);

    /**
     * 删除治理用药管理信息
     * 
     * @param id 治理用药管理主键
     * @return 结果
     */
    public int deleteSysPesticideById(Long id);
}
