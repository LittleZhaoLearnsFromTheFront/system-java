package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysWatering;

/**
 * 浇水管理Service接口
 * 
 * @author hanxiao.zhao
 * @date 2025-05-11
 */
public interface ISysWateringService 
{
    /**
     * 查询浇水管理
     * 
     * @param id 浇水管理主键
     * @return 浇水管理
     */
    public SysWatering selectSysWateringById(Long id);

    /**
     * 查询浇水管理列表
     * 
     * @param sysWatering 浇水管理
     * @return 浇水管理集合
     */
    public List<SysWatering> selectSysWateringList(SysWatering sysWatering);

    /**
     * 新增浇水管理
     * 
     * @param sysWatering 浇水管理
     * @return 结果
     */
    public int insertSysWatering(SysWatering sysWatering);

    /**
     * 修改浇水管理
     * 
     * @param sysWatering 浇水管理
     * @return 结果
     */
    public int updateSysWatering(SysWatering sysWatering);

    /**
     * 批量删除浇水管理
     * 
     * @param ids 需要删除的浇水管理主键集合
     * @return 结果
     */
    public int deleteSysWateringByIds(Long[] ids);

    /**
     * 删除浇水管理信息
     * 
     * @param id 浇水管理主键
     * @return 结果
     */
    public int deleteSysWateringById(Long id);
}
