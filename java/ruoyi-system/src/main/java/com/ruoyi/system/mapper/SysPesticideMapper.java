package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPesticide;

/**
 * 治理用药管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
public interface SysPesticideMapper 
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
     * 删除治理用药管理
     * 
     * @param id 治理用药管理主键
     * @return 结果
     */
    public int deleteSysPesticideById(Long id);

    /**
     * 批量删除治理用药管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPesticideByIds(Long[] ids);
}
